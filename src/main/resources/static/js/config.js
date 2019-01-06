/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function (config) {
    config.toolbarGroups = [
        {name: 'editing', groups: ['find', 'selection', 'spellchecker', 'editing']},
        {name: 'insert', groups: ['insert']},
        {name: 'links', groups: ['links']},
        {name: 'clipboard', groups: ['clipboard', 'undo']},
        {name: 'forms', groups: ['forms']},
        {name: 'tools', groups: ['tools']},
        {name: 'document', groups: ['mode', 'document', 'doctools']},
        {name: 'others', groups: ['others']},
        {name: 'basicstyles', groups: ['basicstyles', 'cleanup']},
        {name: 'paragraph', groups: ['list', 'indent', 'blocks', 'align', 'bidi', 'paragraph']},
        {name: 'styles', groups: ['styles']},
        {name: 'colors', groups: ['colors']},
        {name: 'about', groups: ['about']}
    ];
    config.extraPlugins = 'image2,uploadimage';
    config.removeButtons = 'Underline,Subscript,Superscript,Source,Maximize,About';
    config.removeDialogTabs = 'image:advanced;link:advanced';
    config.removeButtons = 'Underline,Subscript,Superscript,Source,About';
    config.language = 'zh-cn';
    config.height = 600;
    // 设置是使用绝对目录还是相对目录，为空为相对目录
    config.baseHref = '';
    //是否对编辑区域进行渲染 plugins/editingblock/plugin.js
    config.editingBlock = true;
    //编辑器中回车产生的标签
    config.enterMode = CKEDITOR.ENTER_P; //可选：CKEDITOR.ENTER_BR或CKEDITOR.ENTER_DIV
    //默认的字体名 plugins/font/plugin.js
    config.font_defaultLabel = 'Arial';
    //字体编辑时的字符集 可以添加常用的中文字符：宋体、楷体、黑体等 plugins/font/plugin.js
    config.font_names = 'Arial;Times New Roman;Verdana';
    //文字的默认式样 plugins/font/plugin.js
    config.font_style = {
        element: 'span',
        styles: {'font-family': '#(family)'},
        overrides: [{element: 'font', attributes: {'face': null}}]
    };
    //字体默认大小 plugins/font/plugin.js
    config.fontSize_defaultLabel = '12px';
    //字体编辑时可选的字体大小 plugins/font/plugin.js
    config.fontSize_sizes = '8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;72/72px'
    //设置字体大小时 使用的式样 plugins/font/plugin.js
    config.fontSize_style = {
        element: 'span',
        styles: {'font-size': '#(size)'},
        overrides: [{element: 'font', attributes: {'size': null}}]
    };
    //对DIV标签自动进行格式化 plugins/format/plugin.js
    config.format_div = {element: 'div', attributes: {class: 'normalDiv'}};
    //对H1标签自动进行格式化 plugins/format/plugin.js
    //config.format_h1 = { element : 'h1', attributes : { class : 'contentTitle1' } };
    //对H2标签自动进行格式化 plugins/format/plugin.js
    //config.format_h2 = { element : 'h2', attributes : { class : 'contentTitle2' } };
    //对H3标签自动进行格式化 plugins/format/plugin.js
    //config.format_h1 = { element : 'h3', attributes : { class : 'contentTitle3' } };
    //对H4标签自动进行格式化 plugins/format/plugin.js
    //config.format_h1 = { element : 'h4', attributes : { class : 'contentTitle4' } };
    //对H5标签自动进行格式化 plugins/format/plugin.js
    //config.format_h1 = { element : 'h5', attributes : { class : 'contentTitle5' } };
    //对H6标签自动进行格式化 plugins/format/plugin.js
    //config.format_h1 = { element : 'h6', attributes : { class : 'contentTitle6' } };
    //对P标签自动进行格式化 plugins/format/plugin.js
    config.format_p = {element: 'p', attributes: {class: 'normalPara'}};
    //对PRE标签自动进行格式化 plugins/format/plugin.js
    config.format_pre = {element: 'pre', attributes: {class: 'code'}};
    //载入时，以何种方式编辑 源码和所见即所得 "source"和"wysiwyg" plugins/editingblock/plugin.js.
    config.startupMode = 'wysiwyg';
    config.enterMode = CKEDITOR.ENTER_BR;   //  屏蔽换行符<br>
    config.shiftEnterMode = CKEDITOR.ENTER_P;//屏蔽段落<p>

    // kcfinder
    config.filebrowserBrowseUrl = '/files.do?type=files';
    config.filebrowserImageBrowseUrl = '/images.do?type=images';
    config.filebrowserUploadUrl = '/upload.do?type=files';
    config.filebrowserImageUploadUrl = '/images.do?command=QuickUpload&type=Images';
    config.filebrowserFlashUploadUrl = '/flash.do?type=flash';
    config.image_previewText = ' ';
    config.uploadUrl = '/images.do?command=QuickUpload&type=Images&request=json';
};