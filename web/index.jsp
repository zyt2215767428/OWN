<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>$Title$</title>
  <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<table id="mytab"></table>
<input>
<script type="text/html" id="addUserToolBar">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm"  lay-event="addUser">添加用户</button>
  </div>
</script>


<script type="text/html" id="updateUserBar">
  <a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="updateUser">编辑</a>
  <a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delUser" >删除</a>
</script>




</body>
<script src="layui/layui.js"></script>

<script>

    layui.use('table', function(){
        var table = layui.table;
        var $=layui.jquery;//引用layui内置的jquery

        //第一个实例
        table.render({
            elem: '#mytab'
            ,toolbar:"#addUserToolBar"//头部工具栏
            ,url: '/queryUser' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'checkbox'},
                {field: 'id', title: 'ID', width:80, sort: true}
                ,{field: 'uname', title: '用户名', width:380}
                ,{field: 'role', title: '角色', width:180, sort: true,templet:function (obj){
                        return obj.role.rname;
                    }}
                ,{title: '操作', width:380,toolbar:"#updateUserBar"}
            ]]
        });


        //监听toolbar工具栏事件
        table.on("toolbar()",function (obj){
            //添加事件
            if(obj.event=='addUser'){
                layer.open({
                    type:2,//弹出层类型
                    title:"添加用户",
                    content:"/add.jsp",//弹出层内容
                    area: ['60%', '40%']
                });
            }
        })

        //监听右侧删除与修改
        table.on("tool()",function (obj){
            //获取当前用户选择的这行数据
            var data=obj.data;

            //删除事件
            if(obj.event=="delUser"){
                layer.confirm("您确定删除吗?",function (index){
                    //alert('点击确定');
                    //请求后台
                    $.ajax({
                        url:"/delUser/"+data.id,
                        success:function (data){

                            layer.close(index);//关闭窗口
                            //删除成功后刷新表格
                            table.reload('mytab',{
                                url: '/queryUser'//重新访问controller
                            })
                        }
                    })
                },function (){
                    //alert('点击取消');
                })
            }
            //修改事件
            if(obj.event=='updateUser'){
                layer.open({
                    type:2,//弹出层类型
                    title:"修改用户",
                    content:"/queryById/"+data.id,//弹出层内容
                    area: ['60%', '40%']
                });
            }
        })
    });






</script>

</html>
