<template>
  <div class="main-wrap">
    <div class="main-container">
        <div class="title">基本资料</div>
        <div class="form">
            用户名:<div class="msg"> {{name}}</div>
           手机号:<div class="msg"> {{phone}}</div>
           密码:
           <input v-show="isvisible" type="password" placeholder="请输入新密码">
           <div class="msg modify" @click="isvisible = true" v-show="!isvisible">修改</div>
           <div class="msg modify" @click="handleEnter" v-show="isvisible">确认</div>
        </div>
    </div>
  </div>
</template>

<script>
import { modifyPasword } from '@/api/login'
export default {
  name: 'couresIndex',
  data () {
    return {
      isvisible: false,
      name: 'username',
      phone: '19150774047',
      password: ''
    }
  },
  methods: {
    async modifyPasword () {
      this.phoneNum = localStorage.get('phoneNum')
      const resultInfo = await modifyPasword(
        {
          phoneNum: this.phoneNum,
          password: this.password
        }
      )
      this.tips(resultInfo.msg)
    },
    handleEnter () {
      this.isvisible = false
    },
    tips (msg) {
      this.$message({
        type: 'info',
        message: msg
      })
    }
  },
  mounted () {
    this.phone = localStorage.getItem('phoneNum')
    this.name = localStorage.getItem('username')
  }
}
</script>

<style scoped lang="less">
.main-wrap{
    .main-container{
        .form{
            font-size: 15px;
            margin: 20px 0 0 0;
            .msg{
                margin-bottom: 20px;
            }
            .modify{
                cursor: pointer;
                color:#5fa4ff;
            }
        }
        margin: 20px 0 0 40px;
        width: calc(100%- 40px);
    }
    .title {
        font-size:20px;
    }
    width: 100%;
    margin-top:10px;
    border-radius: 10px;
    background-color: #f2f4f7;
}
</style>
