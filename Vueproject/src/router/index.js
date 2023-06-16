import Vue from 'vue'
import VueRouter from 'vue-router'

import Index from "@/views/front/Index.vue";
import adminHome from "@/views/back/adminHome.vue";
import UserLogin from "@/views/front/UserLogin.vue";//用户登录页面
import Register from "@/views/front/UserRegister.vue";

import AddUserInformation from "@/views/back/AddUserInformation.vue";
import UserUpdate from "@/views/back/UserUpdate.vue";
import AdminLogin from "@/views/back/AdminLogin.vue";


//后台
import PageTwo from "@/views/back/PageTwo.vue";
import PageThree from "@/views/back/PageThree.vue";
import PageFour from "@/views/back/PageFour.vue";
import PageFive from "@/views/back/PageFive.vue";
import GoodsUpdate from "@/views/back/GoodsUpdate.vue";



/**
 * 主页
 */


//主页设计和详情展示
import ShoppingHome from "@/views/front/ShoppingHome.vue";
import ShoppingDetail from "@/views/front/ShoppingDetail.vue";
import UserInformation from "@/views/front/UserInformation.vue";
import ChangeInformation from "@/views/front/ChangeInformation.vue";

//后端信息
import AdminInformation from "@/views/back/AdminInformation.vue";
import AdminChangeInformation from "@/views/back/AdminChangeInformation.vue";
//aside

import digital1 from "@/views/Aside/digital1.vue"
import digital2 from "@/views/Aside/digital2.vue"
import digital3 from "@/views/Aside/digital3.vue"

import book1 from "@/views/Aside/book1.vue";
import book2 from "@/views/Aside/book2.vue";
import book3 from "@/views/Aside/book3.vue";

import food1 from  "@/views/Aside/food1.vue";
import food2 from  "@/views/Aside/food2.vue";
import food3 from  "@/views/Aside/food3.vue";

import CartShow from "@/views/front/CartShow.vue";
import OrderShow from "@/views/front/OrderShow.vue";
import GoodsUpload from "@/views/front/GoodsUpload.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/index/home',
  },
  {
    path: '/index',
    name: '起始页',
    component: Index,
    children:[
      {
        path:'home',
        name:'商品购物主页',
        component: ShoppingHome,
      },
      {
        meta: {
          requiresAuth: true // 设置需要登录才能访问
        },
        name: '更新个人信息',
        component: ChangeInformation,
        path: 'change'
      },
      {
        meta: {
          requiresAuth: true // 设置需要登录才能访问
        },
        name:'个人信息',
        path: 'information',
        component: UserInformation,
      },
      {
        name:'商品详情展示',
        component: ShoppingDetail,
        path:'detail',
      },
      {
        path: 'login',
        name:'用户登录页面',
        component: UserLogin
      },
      {
        path: 'register',
        name:'用户注册页面',
        component: Register
      },
      {
        meta: {
          requiresAuth: true // 设置需要登录才能访问
        },
        name:'购物车结算',
        component: CartShow,
        path:'cart',
      },
      {
        meta: {
          requiresAuth: true // 设置需要登录才能访问
        },        name:'旧物上传',
        component: GoodsUpload,
        path: 'upload'
      },
      {
        meta: {
          requiresAuth: true // 设置需要登录才能访问
        },
        name:'订单中心',
        component: OrderShow,
        path: 'order'
      },
      {
        path:'digital1',
        name:'电脑',
        component: digital1,
      },
      {
        path:'digital2',
        name:'手机',
        component: digital2,
      },
      {
        path:'digital3',
        name:'平板',
        component: digital3,
      },
      {
        path:'food1',
        name:'面包',
        component: food1,
      },
      {
        path:'food2',
        name:'牛奶',
        component: food2,
      },
      {
        path:'food3',
        name:'饮料',
        component: food3,
      },
      {
        path:'book1',
        name:'教材',
        component: book1,
      },
      {
        path:'book2',
        name:'人文',
        component: book2,
      },
      {
        path:'book3',
        name:'艺术',
        component: book3,
      },

    ]
  },

  {
    path: '/admin',
    name: '管理员主页',
    component: adminHome,
    meta: {
      requiresAuth: true // 设置需要登录才能访问
    },
    children:[
      {
        path: 'information',
        name: '后台用户信息展示',
        component: AdminInformation,
      },
      {
        path: 'changeinfo',
        name: '后台更新用户信息',
        component: AdminChangeInformation,
      },
      {
        path:'pagetwo',
        name:'用户',
        component: PageTwo,
      },
      {
        path:'pagethree',
        name:'商品1',
        component: PageThree,
      },
      {
        path:'pagefour',
        name:'商品2',
        component: PageFour,
      },
      {
        path:'pagefive',
        name:'商品3',
        component: PageFive,
      },
      {
        path: 'addUser',
        name:'用户信息添加',
        component: AddUserInformation,
        meta: {
          requiresAuth: true // 设置需要登录才能访问
        }
      },
      {
        path: 'update',
        name:'用户更新',
        component: UserUpdate,
        meta: {
          requiresAuth: true // 设置需要登录才能访问
        },
      },
      {
        name:'修改商品状态',
        path: 'change',
        component: GoodsUpdate,
      }
    ]
  },
  {
    path: '/adminLogin',
    name:'后台管理员登录',
    component: AdminLogin
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
  // 判断当前路由是否需要登录才能访问
  if (to.matched.some(record => record.meta.requiresAuth)) {
    // 判断用户是否已经登录
    if (!localStorage.getItem('user')) {
      // 如果没有登录，给出提示
      Vue.prototype.$message.error('您还未登录，请先登录！')
      // 等待2秒后跳转
      setTimeout(() => {
        next('/index/home')
      }, 2000)
      return // 终止路由导航
    }
  }
  // 其他情况继续跳转
  next()
})


export default router
