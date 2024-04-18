import Vue from 'vue'
import VueRouter from 'vue-router'
// 登录注册
import Register from '@/views/login/register.vue'
import Login from '@/views/login/login.vue'

// 主页
import Layout from '@/views/layout/index.vue'
// 展示首页
import MyLayout from '@/views/layout/index/layout.vue'
// 首页的儿子
import Coures from '@/views/layout/index/subindex/course.vue'
import PersonCenter from '@/views/layout/index/subindex/PersonCenter.vue'
// 课程详情
import CourseDetail from '@/views/layout/courseDetail/index.vue'
// 教师管理
import TeachIndex from '@/views/layout/courseDetail/teach.vue'
// 添加题目
import AddQuestion from '@/views/layout/courseDetail/addQuestion/index.vue'
Vue.use(VueRouter)

const routes = [
  { path: '/Register', component: Register },
  { path: '/Login', component: Login },
  {
    path: '/',
    component: Layout,
    children: [
      { path: '', redirect: 'layout' },
      {
        path: 'layout',
        component: MyLayout,
        children: [
          { path: '', redirect: 'Coures' },
          { path: 'Coures', component: Coures },
          { path: 'PersonCenter', component: PersonCenter }
        ]
      },
      { path: 'CourseDetail/student/:id', component: CourseDetail },
      { path: 'CourseDetail/teach/:id', component: TeachIndex }

    ]
  },
  { path: '/AddQuestion/:id', component: AddQuestion }
]

const router = new VueRouter({
  routes
})

export default router
