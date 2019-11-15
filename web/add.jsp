<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div class="layui-container">
    <form class="layui-form" action="/addUser" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="uname" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-block">
                <select id="roleId" name="role.id" lay-verify="required">

                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="layui/layui.js"></script>


<script>

    layui.use(['form','table'],function (){
        var form=layui.form;
        var table=layui.table;
        var $=layui.jquery;//引用layui内置的jquery

        $.ajax({
            url:"/queryRole",
            success:function (data){

                var myselect=document.getElementById("roleId");

                var html="";
                for(var i=0;i<data.length;i++){
                    html+="<option value='"+data[i].id+"'>"+data[i].rname+"</option>";
                }

                myselect.innerHTML=html;
                form.render("select");//重新加载下拉列表
            }
        })

        form.on("submit",function (){

            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭

            //刷新父页面
            //window.parent.location.reload();//刷新父页面
            window.parent.layui.table.reload('mytab',{
                url: '/queryUser'//重新访问controller
            })
        })


    })




</script>


</html>
