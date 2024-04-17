<template>
  <div class="wrap">
    <div class="container">
        <div class="wrap-container">
            <div class="title">用户登录</div>
            <div class="input-wrap"><i class="el-icon-phone"></i><input type="text" placeholder="手机号" v-model="data.phoneNum"></div>

            <div class="input-wrap"><i class="el-icon-lock"></i><input type="password" placeholder="密码" v-model="data.password"></div>
            <div class="handleBtn" @click="handleLogin">登录</div>
            <div class="register"><router-link to="/Register">新用户注册</router-link></div>
            <p>登录即表示同意平台<a href="https://homewh.chaoxing.com/agree/privacyPolicy?appId=900001" class="private" target="_blank">《隐私政策》</a> 和
            <a  class="private" href="https://homewh.chaoxing.com/agree/userAgreement?appId=900001" target="_blank">《用户协议》</a></p>
        </div>

    </div>
  </div>
</template>

<script>
import { login } from '@/api/login.js'
export default {
  name: 'LoginIndex',
  data () {
    return {
      data: {
        phoneNum: '',
        password: ''
      }
    }
  },
  methods: {
    async login () {
      localStorage.setItem('jwt', '123415451212')
      localStorage.setItem('url', 'http://localhost:8080/img/20200729133847_jdvhc.92f6737a.jpg')
      localStorage.setItem('username', '斗城一绝')
      localStorage.setItem('phoneNum', '1915077407')
      const resultInfo = await login(
        {
          phoneNum: this.phoneNum,
          password: this.password
        }
      )
      if (resultInfo.code === 200) {
        localStorage.setItem('jwt', resultInfo.data.token)
        localStorage.setItem('url', resultInfo.data.url)
        localStorage.setItem('username', resultInfo.data.username)
        localStorage.setItem('phoneNum', this.phoneNum)
      }

      this.tips(resultInfo.mgs)
    },
    handleLogin () {
      this.login()
    },
    tips (msg) {
      this.$message({
        type: 'info',
        message: msg
      })
    }
  }
}
</script>

<style scoped lang="less">
.register {
    a {
        color:#3aaaff;
        font-size: 15px;
        margin-top: 10px;
        float:right;
    }
}
p {
    text-align: center;
    font-size: 12px;
    color: #A8A8B3;
    position: relative;
    left: 0px;
    bottom: -60px;
}
.private {
    color: #739aff;
   text-decoration: none;
}

.handleBtn {
    width: 360px;
    height: 60px;
    text-align: center;
    background-color: #616cff;
    line-height: 60px;
    color: #fff;
    font-size: 20px;
    border-radius: 30px;
    cursor: pointer;
}
.input-wrap {
    width: 360px;
    line-height: 48px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    border-radius: 24px;
    font-size: 20px;
    color: #cfd8e6;
    padding: 0;
    position: relative;
    border: 1px solid #3333;
    margin-bottom: 20px;
    i{
        margin: 0 10px 0 10px;
    }
    input {
        border: none;
        display: inline-block;
        height: 48px;
        outline: none;
        width: 80%;
    }
}
.title{
    color: #181E33;
    font-size: 20px;
    margin-bottom: 44px;
}
.wrap-container {
    width: 360px;
    height: 290px;
    position: absolute;
    top: calc(50% - 145px);
    left: calc(50% - 180px);
    input{

    }
}
.title{
        color: #181E33;
    font-size: 20px;
    margin-bottom: 44px;
}
.return_title{
 color: #91A0B5;
 font-weight: 600;
 position: absolute;
 top: 30px;
 left:20px;
    a{
         font-size: 15px;
    }
}
.wrap{
    position: fixed;
    top:0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: #f2f4f7;
    .container {
        position: relative;
        height: 600px;
        width: 500px;
        top: calc(50% - 300px);
        left: calc(50% - 250px);
        background: #ffffff;
        border-radius: 20px;
            box-shadow: 0px 0px 20px 0px rgba(175, 187, 204, 0.2);
    }
}
</style>
