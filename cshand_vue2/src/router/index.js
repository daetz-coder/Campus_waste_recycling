import Vue from 'vue'
import VueRouter from 'vue-router'
import FrontTemplate from "@/views/Template/FrontTemplate.vue"
import ShoppingHome from "@/views/Front/ShoppingHome.vue"
import BookOne from "@/views/Front/BookOne"
import BookTwo from "@/views/Front/BookTwo"
import BookThree from "@/views/Front/BookThree"


Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    redirect: '/front',
  },
  {
    name:'前端模板',
    path:'/front',
    component: FrontTemplate,
    children:[
      {
        name: '商品主页',
        path: 'home',
        component: ShoppingHome,
      },
      {
        name: '商品1',
        path: 'one',
        component: BookOne,
      },
      {
        name: '商品2',
        path: 'two',
        component: BookTwo,
      },
      {
        name: '商品3',
        path: 'three',
        component: BookThree,
      },
    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
