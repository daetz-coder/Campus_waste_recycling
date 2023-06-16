import axios from 'axios'

// 设置默认的请求基础URL和超时时间
const request = axios.create({
  baseURL: 'http://localhost:8081',
  timeout: 30000
})



// request 拦截器
// 可以自请求发送前对请求做一些处理
// 比如统一加token，对请求参数统一加密
request.interceptors.request.use(config => {
  config.headers['Content-Type'] = 'application/json;charset=utf-8';
  let user = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : null
  if (user) {
    config.headers['token'] = user.token;  // 设置请求头
  }
  return config
}, error => {
  return Promise.reject(error)
});

export default request