<template>
    <div>
        <div>
            <div class="line"></div>
            <el-header style="text-align: right; font-size: 12px">
                <span style="text-align: left;position: absolute;left: 2%;font-family: 'Adobe 宋体 Std L';font-weight: bolder;font-size: 20px;color: ivory" >校园旧物回收后台管理系统</span>
                <el-dropdown style="width: 150px; cursor: pointer; text-align: right">
                    <div style="display: inline-block">
                        <img :src="userImage" alt=""
                             style="width: 40px; border-radius: 50%; position: relative; top: 12px;right: 5px">
                        <span style="color: white">{{username}}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
                    </div>
                    <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center">
                        <el-dropdown-item style="font-size: 12px; padding: 5px 0">
                            <router-link to="/index/home" style="text-decoration: none">回到前台</router-link>
                        </el-dropdown-item>
                        <el-dropdown-item style="font-size: 12px; padding: 5px 0">
                            <span style="text-decoration: none" @click="logout">退出</span>
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </el-header>
        </div>
        <div>
            <el-container style="height: 500px; border: 1px solid #eee">
                <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                    <el-menu :default-openeds="['1','2']">
                        <el-submenu index="1">
                            <template slot="title"><i class="el-icon-s-home"></i>个人主页</template>
                                <el-menu-item index="1-1" @click="$router.push({path:'/admin/information'})">信息管理</el-menu-item>
                        </el-submenu>
                        <el-submenu index="2">
                            <template slot="title"><i class="el-icon-setting"></i>系统管理</template>
                            <el-menu-item index="2-1" @click="$router.push({path:'/admin/pagetwo'})">用户管理</el-menu-item>
                            <el-menu-item index="2-2" @click="$router.push({path:'/admin/pagethree'})">类别管理</el-menu-item>
                            <el-menu-item index="2-3" @click="$router.push({path:'/admin/change'})">商品管理</el-menu-item>
                            <el-menu-item index="2-4" @click="$router.push({path:'/admin/pagefive'})">订单管理</el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <el-container>
                    <el-main>
                        <router-view></router-view>
                    </el-main>
                </el-container>
            </el-container>
        </div>
    </div>
</template>
<script>
import request from "@/utils/request";
import router from "@/router";
export default {
    name: "adminHome",
    data() {
        return {
          username:'',
          password:'',
          userImage:'',
        };
    },
  created() {
    const storedUser = localStorage.getItem('user');
    const user = JSON.parse(storedUser);
    this.username=user.username
    this.userImage=user.avatar

    // if (token) {
    //   const _this=this
    //   request.post('http://localhost:8081/token').then(function (resp){
    //     _this.username = resp.data.username;
    //     _this.nickname=resp.data.nickname
    //     _this.avatarURL = resp.data.avatarURL;
    //     console.log(resp.data)
    //   })
    // }
  },
  methods: {
    handleSelect(key, keyPath) {
        console.log(key, keyPath);
    },
    logout() {
      // 调用 Vue Router 的 push 方法，将路径跳转到 '/login'
      router.push('/index/login')
      // 删除本地存储的用户信息
      localStorage.removeItem('user')
      // 显示退出成功的消息
      this.$message.success('退出成功')
    }
  }
}
</script>

<style scoped>
.el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
}

.el-aside {
    color: #333;
}
</style>