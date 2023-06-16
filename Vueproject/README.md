### 说明书
**1、用户主页：**  
主页：http://localhost:8080/  
用户只需要使用
http://localhost:8080/ 即可访问主页  
主页的真实路径是
http://localhost:8080/index/body
![主页展示](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301722445.png)

**2、登录注册页面**

登录：http://localhost:8080/user/login  
![登录页面](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301724927.png)  
提供管理员登录和用户登录  
用户名:daetz  
密码：123456  
登陆成功后会返回主页，并给出相关的提示，提示登录成功
![登录成功](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301728694.png)


注册：http://localhost:8080/user/register
![注册页面](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301730314.png)
注册需要用户输入个人信息，大部分都是使用小组件完成


**3、后台页面**  
后台主页：http://localhost:8080/admin
用户只需要使用
http://localhost:8080/admin 即可访问管理员后台  
管路员主页的真实路径是 http://localhost:8080/admin/pageone
![后台页面展示](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301756867.png)

**4、Token测试点**  
用户可以使用 http://localhost:8080/admin/pagetwo  
来检测数据前端后端数据是否互通，以及Token是否能正常被放入请求头中。

![Token测试](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301803824.png)


二、bug记录

1、使用utils设置config.js导致Token未能正常放入请求头
![image-20230530182053448](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301820346.png)


检测发现是命名未统一，包含user和username
![image-20230530182148835](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301821047.png)


仍然出错，忘记修改成request了

确保你在发送请求时使用了request对象来发起请求，而不是直接使用axios

请确保你使用了request对象发送请求，并且在发送请求时会自动应用拦截器中设置的请求头。如果你直接使用axios对象发送请求，那么拦截器中设置的请求头将不会生效。
![image-20230530190125643](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301901190.png)






2、路由守卫失效

- 忘记导入Vue
  ![](https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202305301848787.png)


在代码中，导入Vue是为了使用Vue.prototype.$message.error，该语句用于在路由守卫中显示错误消息。

Vue.prototype.$message.error是使用Vue的原型属性$message来显示错误消息的方法。通过导入Vue，你可以在路由守卫中访问Vue实例，并使用$message.error方法来显示错误消息。

请注意，确保你的项目中已经安装并正确导入了Vue库。如果你的项目中没有使用Vue，或者没有安装Vue相关依赖，那么你可能不需要导入Vue。但在代码中使用了Vue.prototype.$message.error的情况下，需要确保Vue正确导入和配置。

    import request from '@/utils/request'; // 导入自定义的request对象
    
    export default {
        name: "PageTwo",
        methods:{
          search() {
              const _this = this;
              request.get('/admin/findByName/' + _this.input2).then(function(resp) {
                console.log(resp);
                _this.tableData = resp.data;
                _this.total = resp.data.length;
              });
            },
            addUser(){
              this.$router.push('/addUser')
            },
            resetForm(){
                this.input1='';
                this.input2='';
            },
            deleteUser(row){
              const _this=this
              request.post('/admin/delete/'+row.id).then(function (resp){
                //console.log(resp)
                alert("删除成功")
                window.location.reload();
              })
            },
            edit(row) {
              this.$router.push({
                path:'/update',
                query:{
                  id:row.id
                }
              })
               //row.id<点击的id>
            },
            page(currentPage){ //alert("wait...") 动态分页
                const _this=this
                request.get('/findUser/'+currentPage+'/3').then(function (resp){
                    _this.tableData=resp.data.records
                    _this.total=resp.data.total
                })
            }
        },
      created() {
          const _this = this;
          request.get('/findUser/1/3').then(function(resp) {
            _this.tableData = resp.data.records;
            _this.total = resp.data.total;
            _this.size = resp.data.size;
            console.log(resp.data);
          });
        },
        data() {
            return {
                input1: '',
                input2: '',
                total:null,
                tableData:null,
                avatar:''
            }
        }
    }




