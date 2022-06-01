import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//引入elementplus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

createApp(App).use(store).use(router).use(ElementPlus,{locale: zhCn,}).mount('#app')
