/**
 * 初始化详情对话框
 */
var ZtoSchedulingManagerInfoDlg = {
    ZtoSchedulingManagerInfoData : {}
};

/**
 * 清除数据
 */
ZtoSchedulingManagerInfoDlg.clearData = function() {
    this.ZtoSchedulingManagerInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ZtoSchedulingManagerInfoDlg.set = function(key, val) {
    this.ZtoSchedulingManagerInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ZtoSchedulingManagerInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ZtoSchedulingManagerInfoDlg.close = function() {
    parent.layer.close(window.parent.ZtoSchedulingManager.layerIndex);
}

/**
 * 收集数据
 */
ZtoSchedulingManagerInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
ZtoSchedulingManagerInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ZtoSchedulingManager/add", function(data){
        Feng.success("添加成功!");
        window.parent.ZtoSchedulingManager.table.refresh();
        ZtoSchedulingManagerInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ZtoSchedulingManagerInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ZtoSchedulingManagerInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ZtoSchedulingManager/update", function(data){
        Feng.success("修改成功!");
        window.parent.ZtoSchedulingManager.table.refresh();
        ZtoSchedulingManagerInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ZtoSchedulingManagerInfoData);
    ajax.start();
}

$(function() {

});
