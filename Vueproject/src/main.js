import Vue from 'vue'

import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import request from "@/utils/request";
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false
import { Message } from 'element-ui';

Vue.use(ElementUI);

Vue.prototype.$message = function(msg) {
  return Message({
    message: msg,
    duration: 1000
  });
};
// 分别对success、warning和error等样式进行设置
Vue.prototype.$message.success = function(msg) {
  return Message.success({
    message: msg,
    duration: 1000
  });
};
Vue.prototype.$message.info = function(msg) {
  return Message.info({
    message: msg,
    duration: 1000
  });
};
Vue.prototype.$message.error = function(msg) {
  return Message.error({
    message: msg,
    duration: 1000
  });
};

Vue.prototype.request=request

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
