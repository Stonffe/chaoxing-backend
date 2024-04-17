<template>
  <div class="clearfix">
    <div class="top">
      <div class="logo">
        <img src="@/assets/pic/logo.png">
      </div>
      <div clsss="top-msg">
        <router-link to="" class="top-link">
          <div class="top-pic"><img src="@/assets/pic/20200729133847_jdvhc.jpg" ></div>
           <div class="top-name"><p>用户</p></div>
        </router-link>
      </div>
    </div>
    <div class="main clearfix">
    <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LayoutIndex'
}
</script>

<style lang="less" scoped>

.logo {
  width: 82px;
  height: 28px;
  position: absolute;
  top:20px;
  left:20px;
  img{
    height: 100%;
    width: 100%;
  }
}
.main{
    margin-top: 75px;

}
.top {
    position: fixed;
    height: 70px;
    top:0;
    left: 0;
    right: 0;
    background-color: #ffffff;
    border: 1px dotted #3333;
    box-shadow: 1px 5px 5px #888888;

    .top-link {
      position: absolute;
      right:0;
      height: 70px;
      display: flex;
      .top-pic{
         display: inline-block;
      height: 100%;
      line-height: 90px;
        img{
           height: 30px;
            width: 30px;
            border-radius: 30px;
        }
    }
    .top-name{
      display: inline-block;
      height: 100%;
      line-height: 70px;
      margin: 0 10px 0 10px;
    }
    }
}
</style>
