//var mymap = null;
var info;
var block, parcel, okso;
$(document).ready(function(){
    if($('#mapContent').val().length > 0){
        var mapData = JSON.parse($('#mapContent').val());
        if(mapData != undefined && mapData.length > 0){
            var defcrs = getCRS(mapData);
            proj4.defs(defcrs);

            // var center = JSON.parse(mapData[0].layout).features[0].geometry.coordinates[0][0];
            var mymap = new L.map('tmpMap');
            // create the tile layer with correct attribution
            var osmUrl='https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
            // var osmUrl='https://cartodb-basemaps-{s}.global.ssl.fastly.net/dark_nolabels/{z}/{x}/{y}.png';
            var osmAttrib='Map data © <a href="https://openstreetmap.org">OpenStreetMap</a> contributors';
            var osm = new L.TileLayer(osmUrl, {maxZoom: 18, attribution: osmAttrib});
            mymap.addLayer(osm);

            mymap.createPane("cadastrPane");
            mymap.createPane("parcelPane");
            mymap.createPane("oksPane");

            var center = undefined;
            $(mapData).each(function(i, el){
                block = L.Proj.geoJson(JSON.parse(el.layout), {
                    style: style('block'),
                    pane: 'cadastrPane',
                    onEachFeature: function (feature, layer) {
                        layer.on({
                            mouseover: highlightFeature,
                            mouseout: resetHighlight
                        });

                        if(center == undefined){
                            if(layer.getLatLngs().length > 0){
                                if(layer.getLatLngs()[0].length > 0){
                                    center = [layer.getLatLngs()[0][0].lat,layer.getLatLngs()[0][0].lng];
                                }
                            }
                        }
                    }
                }).addTo(mymap);

                $(el.parcels).each(function(j, par){
                    parcel = L.Proj.geoJson(JSON.parse(par), {
                        style: style('parcel'),
                        onEachFeature: onEachFeature,
                        pane: 'parcelPane'
                    }).addTo(mymap);
                });

                $(el.oks).each(function(k, oks){
                    okso = L.Proj.geoJson(JSON.parse(oks), {
                        style: style('oks'),
                        onEachFeature: onEachFeature,
                        pane: 'oksPane'
                    }).addTo(mymap);
                });
            });

            if(center == undefined){
                center = [61,69];
            }
            mymap.setView(center,13);
            //Легенда
            var legend = L.control({position: 'bottomright'});
            legend.onAdd = function (mymap) {
                var div = L.DomUtil.create('div', 'info legend'),
                    grades = ['block','parcel','oks'];
                // loop through our density intervals and generate a label with a colored square for each interval
                for (var i = 0; i < grades.length; i++) {
                    div.innerHTML +=
                        '<i style="background:' + getColor(grades[i]) + '"></i> ' + getLegendText(grades[i]) + '<br>';
                }
                return div;
            };
            legend.addTo(mymap);

            //Информация об объекте
            info = L.control({position: 'bottomleft'});
            info.onAdd = function (mymap) {
                this._div = L.DomUtil.create('div', 'info'); // create a div with a class "info"
                this.update();
                return this._div;
            };
            // method that we will use to update the control based on feature properties passed
            info.update = function (props) {

                if(props == undefined){
                    this._div.innerHTML = '<h4>Выберите объект</h4>'
                }else{
                    this._div.innerHTML = '<h4>Информация об объекте</h4>'
                    var content = '';
                    $(Object.entries(props)).each(function(i, el){
                        if(el[1]!= null && el[1] != undefined && el[1].toString().toUpperCase() !== 'NULL' && el[1].toString().toUpperCase() !== 'UNKNOWN'){
                            content += '<b>' + el[0] +'</b>: ' + el[1] + '<br/>';
                        }
                    });
                    this._div.innerHTML += content;
                }
            };

            info.addTo(mymap);

        }
    }
});

function getCRS(data){
    var defcrs = [];
    $(data).each(function (i, el) {
        if(el.layout != null){
            var crs = JSON.parse(el.layout).crs.properties.name;
            var ind = defcrs.findIndex(function(el){
                return el[0] == crs;
            });
            if(ind < 0) {
                defcrs.push([crs, crs]);
            }

            $(el.parcels).each(function (j, pr) {
                crs = JSON.parse(pr).crs.properties.name;
                ind = defcrs.findIndex(function(el){
                    return el[0] == crs;
                });
                if(ind < 0) {
                    defcrs.push([crs, crs]);
                }
            });

            $(el.oks).each(function (k, oks) {
                crs = JSON.parse(oks).crs.properties.name;
                ind = defcrs.findIndex(function(el){
                    return el[0] == crs;
                });
                if(ind < 0) {
                    defcrs.push([crs, crs]);
                }
            });
        }
    });
    return defcrs
}

function getColor(sh){
    return sh == 'block'? '#e2ab07':
            sh == 'parcel'? '#007bff':
            sh == 'oks'? '#32d35c':'#fff';
}
function getLegendText(sh){
    return sh == 'block'? 'Граница кадастрового квартала':
            sh == 'parcel'? 'Граница земельного участка':
            sh == 'oks'? 'Граница сооружения':'';
}

function onEachFeature(feature, layer) {
    layer.on({
        mouseover: highlightFeature,
        mouseout: resetHighlight
    });
}

function highlightFeature(e){
    var layer = e.target;
    layer.setStyle({
        weight: 5,
        color: '#dc3545',
        dashArray: '',
        fillOpacity: 0.7
    });

    if (!L.Browser.ie && !L.Browser.opera && !L.Browser.edge) {
        layer.bringToFront();
    }
    info.update(layer.feature.properties)
}

function resetHighlight(e){
    switch(e.target.defaultOptions.pane){
        case 'cadastrPane':
            if(block != undefined && block != null){
                block.resetStyle(e.target)
            }
            break;
        case 'parcelPane':
            if(parcel != undefined && parcel != null){
                parcel.resetStyle(e.target)
            }
            break;
        case 'oksPane':
            if(okso != undefined && okso != null){
                okso.resetStyle(e.target)
            }
            break;
    }
    info.update();
}

function style(type) {
    return {
        // fillColor: getColor(type),
        weight: 2,
        opacity: 1,
        color: getColor(type),
        dashArray: '3',
        fillOpacity: 0.7
    };
}