import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import '@/utils/utils/Element-ui.js'
import '@/style/global.less'
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
