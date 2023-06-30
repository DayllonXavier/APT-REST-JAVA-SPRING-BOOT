import { createRouter, createWebHistory } from 'vue-router'
import ListHome from '../views/ListHome.vue'

const routes = [
  {
    path: '/',
    name: 'listhome',
    component: ListHome
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
