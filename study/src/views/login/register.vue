<template>
  <div class="wrap">
    <div class="container">
        <div><router-link to="/Login" class="return_title"><i class="el-icon-arrow-left"><a>返回</a></i></router-link></div>
        <div class="wrap-container">
            <div class="title">新用户注册</div>
            <div class="input-wrap"><i class="el-icon-phone"></i><input type="text" placeholder="手机号"></div>
            <div class="input-wrap"><i class="el-icon-user"></i><input type="text" placeholder="账号名字"></div>
            <div class="input-wrap"><i class="el-icon-lock"></i><input type="password" placeholder="密码"></div>
            <div class="handleBtn">注册</div>
            <p>登录即表示同意平台<a href="https://homewh.chaoxing.com/agree/privacyPolicy?appId=900001" class="private" target="_blank">《隐私政策》</a> 和
            <a  class="private" href="https://homewh.chaoxing.com/agree/userAgreement?appId=900001" target="_blank">《用户协议》</a></p>
        </div>

    </div>
  </div>
</template>

<script>
export default {
  name: 'registerIndex'
}
</script>

<style scoped lang="less">
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
