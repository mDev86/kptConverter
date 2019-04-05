var isAdvancedUpload = function() {
    var div = document.createElement('div');
    return (('draggable' in div) || ('ondragstart' in div && 'ondrop' in div)) && 'FormData' in window && 'FileReader' in window;
}();

$(document).ready(function(){
    var $form = $('.box_drag');
    // var filesinput = $("#${p:component('file').replaceAll(':','\\\\\\\\:')}_input");
    var filesinput = $('input[type=file]');
    var $label = $form.find('label');

    function cleanFile(text){
        $label.text(text);
        filesinput[0].value = '';
    }

    showFiles = function(files) {
        // $label.text(files.length > 1 ? ($input.attr('data-multiple-caption') || '').replace( '{count}', files.length ) : files[ 0 ].name);
        if(files.length > 1){
            cleanFile('Невозможно прикрепить несколько файлов');
            /*$label.text('Невозможно прикрепить несколько файлов');
            filesinput[0].value = '';*/
        }else if(files.length > 0){
            var oneFile = files[0];
            if(oneFile.name.lastIndexOf('.') < 0 || oneFile.name.substr((oneFile.name.lastIndexOf('.') + 1)) != 'zip'){
                cleanFile('Неверный формат файла. Выберите zip архив')
            }else if(oneFile.size > 10000000){
                cleanFile('Размер файла превышает установленный лимит')
                /*$label.text('Размер файла превышает установленный лимит');
                filesinput[0].value = '';*/
            }else{
                $label.text(files[0].name);
                if(filesinput[0].files.length == 0){
                    filesinput[0].files = files;
                }
            }
        }
    };

    if (isAdvancedUpload) {
        $form.addClass('has-advanced-upload');

        var droppedFiles = false;

        $form.on('drag dragstart dragend dragover dragenter dragleave drop', function(e) {
            e.preventDefault();
            e.stopPropagation();
        })
            .on('dragover dragenter', function() {
                $form.addClass('is-dragover');
            })
            .on('dragleave dragend drop', function() {
                $form.removeClass('is-dragover');
            })
            .on('drop', function(e) {
                e.preventDefault();
                droppedFiles = e.originalEvent.dataTransfer.files;
                filesinput[0].value = '';
                showFiles( droppedFiles );
            });
    }

    filesinput.on('change', function(e) {
        showFiles(e.target.files);
    });

});
