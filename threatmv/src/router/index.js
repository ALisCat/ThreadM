import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../Layout/Layout.vue'

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect:'/wx01',
    children:[
      {
        path:'/wx01',
        name:'wx01',
        component: () => import("@/views/WX01.vue"),
      },
    ]
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
