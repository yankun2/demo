/**
 * 管理初始化
 */
var ZtoSchedulingManager = {
    id: "ZtoSchedulingManagerTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ZtoSchedulingManager.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
	     {title: 'Id', field: 'id', align: 'center', valign: 'middle'},
	     {title: '中心ID', field: 'centerId', align: 'center', valign: 'middle'},
	     {title: '中心名称', field: 'centerName', align: 'center', valign: 'middle'},
	     {title: '员工名称', field: 'employeeName', align: 'center', valign: 'middle'},
	     {title: '工号', field: 'jobNumber', align: 'center', valign: 'middle'},
	     {title: '岗位编码', field: 'postCode', align: 'center', valign: 'middle'},
	     {title: '岗位名称', field: 'postName', align: 'center', valign: 'middle'},
	     {title: '组织编码', field: 'orgCode', align: 'center', valign: 'middle'},
	     {title: '组织名称', field: 'organizationName', align: 'center', valign: 'middle'},
	     {title: '班次编码', field: 'classCode', align: 'center', valign: 'middle'},
	     {title: '排班时间', field: 'schedulingDate', align: 'center', valign: 'middle'},
	     {title: '排班类型', field: 'schedulingType', align: 'center', valign: 'middle'},
	     {title: '仓位', field: 'position', align: 'center', valign: 'middle'},
	     {title: '仓位编码', field: 'positionCode', align: 'center', valign: 'middle'},
	     {title: '绩效类型', field: 'performanceType', align: 'center', valign: 'middle'},
	     {title: '绩效分类', field: 'performanceClass', align: 'center', valign: 'middle'},
	     {title: '单价', field: 'unit', align: 'center', valign: 'middle'},
	     {title: '操作量-数量（票）', field: 'operationVolume', align: 'center', valign: 'middle'},
	     {title: '个人操作量', field: 'personalOperationVolume', align: 'center', valign: 'middle'},
	     {title: '操作量-重量（顿）', field: 'operationVolumeWeight', align: 'center', valign: 'middle'},
	     {title: '扫描类型', field: 'scanType', align: 'center', valign: 'middle'},
	     {title: '把枪账号', field: 'gunLoginId', align: 'center', valign: 'middle'},
	     {title: '操作时间段开始时间', field: 'startTime', align: 'center', valign: 'middle'},
	     {title: '操作时间段结束时间', field: 'endTime', align: 'center', valign: 'middle'},
	     {title: '操作量计算状态（1已计算，0未计算）', field: 'operationVolumeState', align: 'center', valign: 'middle'},
	     {title: '上班状态', field: 'workingState', align: 'center', valign: 'middle'},
	     {title: '状态（1删除，0未删除）', field: 'state', align: 'center', valign: 'middle'},
	     {title: '添加人', field: 'createUser', align: 'center', valign: 'middle'},
	     {title: '添加人code', field: 'createCode', align: 'center', valign: 'middle'},
	     {title: '添加时间', field: 'createDate', align: 'center', valign: 'middle'},
	     {title: '修改人', field: 'modifyUser', align: 'center', valign: 'middle'},
	     {title: '修改人code', field: 'modifyCode', align: 'center', valign: 'middle'},
	     {title: '修改时间', field: 'modifyDate', align: 'center', valign: 'middle'},
	     {title: '非正常工作开始时间', field: 'nonWorkStartTime', align: 'center', valign: 'middle'},
	     {title: '非正常上班结束时间', field: 'nonWorkEndTime', align: 'center', valign: 'middle'},
	     {title: '时长', field: 'lengthOfTime', align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
ZtoSchedulingManager.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ZtoSchedulingManager.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
ZtoSchedulingManager.openAddZtoSchedulingManager = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/ztoschedulingmanager/goto_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
ZtoSchedulingManager.openZtoSchedulingManagerDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/ztoschedulingmanager/goto_update/' + ZtoSchedulingManager.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
ZtoSchedulingManager.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/ztoschedulingmanager/delete", function (data) {
            Feng.success("删除成功!");
            ZtoSchedulingManager.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("ztoschedulingmanagerId",this.seItem.id);
        ajax.start();
    }
};

ZtoSchedulingManager.formParams = function() {
    var queryData = {};
    return queryData;
};

/**
 * 查询列表
 */
ZtoSchedulingManager.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ZtoSchedulingManager.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ZtoSchedulingManager.initColumn();
    var table = new BSTable(ZtoSchedulingManager.id, "/ztoschedulingmanager/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(ZtoSchedulingManager.formParams());
    ZtoSchedulingManager.table = table.init();
});
