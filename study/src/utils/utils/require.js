import axios from 'axios'
axios.defaults.withCredentials = true
// create axios instance
// 新创的不会污染原始axios实例，就能创建多个
const instance = axios.create({
  baseURL: 'http://192.168.1.7:8080',
  //   超时时间
  timeout: 5000
//   headers: { 'X-Custom-Header': 'foobar' }
})

// 自定义配置 - 请求/响应拦截器
// 添加请求拦截器
instance.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  return config
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error)
})

// 添加响应拦截器
instance.interceptors.response.use(function (response) {
  // 2xx 范围内的状态码都会触发该函数。
  // 对响应数据做点什么
//   默认会多一层data数据
  return response.data
}, function (error) {
  // 超出 2xx 范围的状态码都会触发该函数。
  // 对响应错误做点什么
  return Promise.reject(error)
})

export default instance
