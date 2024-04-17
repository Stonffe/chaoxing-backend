<<<<<<< HEAD
<template>
  <div class="wrap">
    <div class="nav fl">
        <div class="nav-pic" to="">
            <router-link  to="#"><img src="@/assets/pic/20200729133847_jdvhc.jpg">
            <div class="username">{{username}}</div>
            </router-link>
                                <div class="inputClass">
                <div class="input">输出邀请码
                    </div>
                </div>
        </div>
        <ul>
            <li v-for="item in list" :key="item.id">
                <router-link :to="item.url"><i :class="item.icon"></i>{{item.name}}</router-link>
            </li>
        </ul>
    </div>
    <div class="main fr">
        <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MyLayout',
  data () {
    return {
      username: '账号',
      list: [
        { id: 1, name: '首页', url: 'Coures', icon: 'el-icon-s-home' },
        { id: 2, name: '我的', url: 'PersonCenter', icon: 'el-icon-user-solid' }
      ]
    }
  }
}
</script>

<style lang="less" scoped>
.inputClass{
    width:100%;

    .input{
        text-align: center;
       height: 30px;
       width: 120px;
       margin: 0 auto;
       border: 1px solid #50b8fd;
       border-radius: 20px;line-height: 30px;
       cursor: pointer;
       color:  #50b8fd;
    }
}
.nav {
    ul{
        width: 100%;
        height: 40px;

        li{
            width: 100%;
            height: 100%;

            a{
                display: inline-block;
                height: 100%;
                width: 100%;
                line-height: 40px;
                i{
                    margin:0 10px 0 40px;
                    color:#b4b6b8;
                    font-size: 20px;
                }
            }
        }
    }
    width: 220px;
    background: #f9f9f9;
    position: fixed;
    top:80px;
    bottom:0;
    border-top-left-radius: 20px;
     border-top-right-radius: 20px;
     .nav-pic {
        display: inline-block;
        width: 100%;
        height: 165px;
        // background-color: red;
        border-bottom: 1px dotted #3333;
        .username{
            width: 100%;
            text-align: center;
            font-size: 18px;
        }
        img{
            display: inline-block;
            height: 80px;
            width: 80px;
            border-radius: 80px;
            margin:15px 0  0 70px;
        }
     }
}
.main {
    float: left;
    padding: 0px;
    width: 980px;
    margin-left: 230px;
    margin-bottom: 64px;
    background-color:#ffffff;
}
.wrap {
   margin:0 auto;
   background-color: red;
   width: 1267px;
}
</style>
=======
<template>
  <div class="wrap">
    <div class="nav fl">
        <div class="nav-pic" to="">
            <router-link  to="#"><img src="@/assets/pic/20200729133847_jdvhc.jpg">
            <div class="username">{{username}}</div>
            </router-link>
                                <div class="inputClass">
                <div class="input">输出邀请码
                    </div>
                </div>
        </div>
        <ul>
            <li v-for="item in list" :key="item.id">
                <router-link :to="item.url"><i :class="item.icon"></i>{{item.name}}</router-link>
            </li>
        </ul>
    </div>
    <div class="main fr">
        <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MyLayout',
  data () {
    return {
      username: '账号',
      list: [
        { id: 1, name: '首页', url: 'Coures', icon: 'el-icon-s-home' },
        { id: 2, name: '我的', url: 'PersonCenter', icon: 'el-icon-user-solid' }
      ]
    }
  }
}
</script>

<style lang="less" scoped>
.inputClass{
    width:100%;

    .input{
        text-align: center;
       height: 30px;
       width: 120px;
       margin: 0 auto;
       border: 1px solid #50b8fd;
       border-radius: 20px;line-height: 30px;
       cursor: pointer;
       color:  #50b8fd;
    }
}
.nav {
    ul{
        width: 100%;
        height: 40px;

        li{
            width: 100%;
            height: 100%;

            a{
                display: inline-block;
                height: 100%;
                width: 100%;
                line-height: 40px;
                i{
                    margin:0 10px 0 40px;
                    color:#b4b6b8;
                    font-size: 20px;
                }
            }
        }
    }
    width: 220px;
    background: #f9f9f9;
    position: fixed;
    top:80px;
    bottom:0;
    border-top-left-radius: 20px;
     border-top-right-radius: 20px;
     .nav-pic {
        display: inline-block;
        width: 100%;
        height: 165px;
        // background-color: red;
        border-bottom: 1px dotted #3333;
        .username{
            width: 100%;
            text-align: center;
            font-size: 18px;
        }
        img{
            display: inline-block;
            height: 80px;
            width: 80px;
            border-radius: 80px;
            margin:15px 0  0 70px;
        }
     }
}
.main {
    float: left;
    padding: 0px;
    width: 980px;
    margin-left: 230px;
    margin-bottom: 64px;
    background-color:#ffffff;
}
.wrap {
   margin:0 auto;
   background-color: red;
   width: 1267px;
}
</style>
>>>>>>> d7dd708bb09340aabbbe4f3d8911b57d9a48194a
