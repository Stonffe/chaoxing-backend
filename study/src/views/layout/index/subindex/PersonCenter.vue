<<<<<<< HEAD
<template>
  <div class="main-wrap">
    <div class="main-container">
        <div class="title">基本资料</div>
        <div class="form">
            用户名:<div class="msg"> {{name}}</div>
           手机号:<div class="msg"> {{phone}}</div>
           密码:<div class="msg modify">修改</div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'couresIndex',
  data () {
    return {
      name: 'username',
      phone: '19150774047'
    }
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
=======
<template>
  <div class="main-wrap">
    <div class="main-container">
        <div class="title">基本资料</div>
        <div class="form">
            用户名:<div class="msg"> {{name}}</div>
           手机号:<div class="msg"> {{phone}}</div>
           密码:<div class="msg modify">修改</div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'couresIndex',
  data () {
    return {
      name: 'username',
      phone: '19150774047'
    }
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
>>>>>>> d7dd708bb09340aabbbe4f3d8911b57d9a48194a
