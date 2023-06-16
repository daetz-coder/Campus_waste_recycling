<template>
    <div>
        <el-header>
            <div class="line"></div>
            <el-menu
                    :default-active="activeIndex"
                    class="el-menu-demo"
                    mode="horizontal"
                    background-color="#545c64"
                    text-color="#fff"
                    active-text-color="#ffd04b">
                <el-menu-item index="1" style="font-family: 'Adobe 宋体 Std L';font-weight: bolder;font-size: 20px;color: rgb(211,83,71)">校园旧物回收商城</el-menu-item>
                <el-menu-item index="2" @click="$router.push({path:'/index/home'})">首页</el-menu-item>
                <el-menu-item index="3" @click="$router.push({path:'/index/upload'})">旧物上传</el-menu-item>
                <el-menu-item index="4" @click="$router.push('/index/cart')">购物车</el-menu-item>
                <el-menu-item index="5" @click="$router.push('/index/information')">个人中心</el-menu-item>
                <el-menu-item index="6" @click="$router.push('/index/order')">订单管理</el-menu-item>

                <el-menu-item index="7">
                    <el-input v-model="input" placeholder="关键字检索" style="width: 200px;margin:0px 10px"><i class="el-icon-search"></i></el-input>
                    <el-button style="width: 70px;">查询</el-button>
                </el-menu-item>
                <el-menu-item index="8">
                    <el-button size="small" @click="$router.push('/index/login')">登录</el-button>
                </el-menu-item>
                <el-menu-item index="9">
                    <el-button size="small" @click="$router.push('/index/register')">注册</el-button>
                </el-menu-item>
                <el-menu-item index="10">
                    <el-dropdown style="width: 150px; cursor: pointer; text-align: right">
                        <div style="display: inline-block">
                            <img :src="userImage" alt=""
                                 style="width: 40px; border-radius: 50%; position: relative; right: 5px">
                            <span style="color: white">{{username}}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
                        </div>
                        <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center">
                            <el-dropdown-item style="font-size: 12px; padding: 5px 0">
                                <router-link v-if="role==='1'" to="/admin/information" style="text-decoration: none">后台管理</router-link>
                            </el-dropdown-item>
                            <el-dropdown-item style="font-size: 12px; padding: 5px 0">
                                <span style="text-decoration: none" @click="logout">退出</span>
                            </el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </el-menu-item>
            </el-menu>
            </el-header>
        <div>
            <el-container>
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu :default-openeds="['1','2','3']">
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-phone"></i>数码</template>
                        <el-menu-item index="1-1" @click="$router.push('/index/digital1')">电脑</el-menu-item>
                        <el-menu-item index="1-2" @click="$router.push('/index/digital2')">手机</el-menu-item>
                        <el-menu-item index="1-3" @click="$router.push('/index/digital3')">平板</el-menu-item>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-cold-drink"></i>美食</template>
                        <el-menu-item index="2-1" @click="$router.push('/index/food1')">面包</el-menu-item>
                        <el-menu-item index="2-2" @click="$router.push('/index/food2')">牛奶</el-menu-item>
                        <el-menu-item index="2-3" @click="$router.push('/index/food3')">饮料</el-menu-item>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title"><i class="el-icon-notebook-1"></i>图书</template>
                        <el-menu-item index="3-1" @click="$router.push('/index/book1')">教材</el-menu-item>
                        <el-menu-item index="3-2" @click="$router.push('/index/book2')">人文</el-menu-item>
                        <el-menu-item index="3-3" @click="$router.push('/index/book3')">艺术</el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>
                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </div>
    </div>
</template>

<script>

import router from "@/router";

export default {
  name: "Index",
  data() {
      return {
        activeIndex: '',
        input: '',
        username:'',
        password:'',
        userImage:'',
        role:'',
      }
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
  },
  created() {
    const storedUser = localStorage.getItem('user');
    const user = JSON.parse(storedUser);
    this.username=user.username
    this.userImage=user.avatar
    this.role=user.role
    console.log(this.role)
  },
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