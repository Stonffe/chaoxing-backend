import request from '@/utils/utils/require.js'

// 注册
export const register = (data) => {
  return request.post('/register', data)
}

// 登录
export const login = (data) => {
  return request.post('/login', data)
}

// 修改
export const modifyPasword = (data) => {
  return request.post('/modifyPasword', data)
}
// export const deleteAddressById = (data) => {
//     return request.get('/login')
//   }
