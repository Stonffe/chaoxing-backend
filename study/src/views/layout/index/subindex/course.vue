<<<<<<< HEAD
<template>
  <div class="main-wrap">
    <div class="main-top">
        <div :class="{'main-top-btn': true, 'main-active': isBtn}" @click="isBtn = true">我学的课</div>
        <div :class="{'main-top-btn': true, 'main-active': !isBtn}" @click="isBtn = false">我学的课</div>
    </div>
    <ul class="main-container">
        <li class="one" v-for="item in dataList" :key="item.id">
            <router-link :to="'/CourseDetail/' + `${item.role === 1 ? 'tearch' : 'student'}/` + `${item.id}`">
            <img src="@/assets/pic/ce2acc035bc2116e4f096ac1b9ff1a05.jpg">
            <h3>{{item.name}}</h3>
            </router-link>

        </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'couresIndex',
  data () {
    return {
      isBtn: true,
      dataList: [
        { id: 1, name: '数字逻辑', url: '@/assets/pic/20200729133847_jdvhc.jpg', role: 1 },
        { id: 2, name: '数字逻辑', url: '@/assets/pic/20200729133847_jdvhc.jpg', role: 0 },
        { id: 1, name: '数字逻辑', url: '@/assets/pic/20200729133847_jdvhc.jpg', role: 1 },
        { id: 1, name: '数字逻辑', url: '@/assets/pic/20200729133847_jdvhc.jpg', role: 0 }
      ]
    }
  }
}
</script>

<style scoped lang="less">
.main-wrap{
    // 内容
    .main-container{
        .one{
            h3{
                margin: 10px  0 0 0;
            }
            display: inline-block;
            img{
                width: 100%;
                height: 130px;
                border-radius: 10px;
            }
            width: 240px;
            height: 300px;
            // background-color: red;
            margin:0 40px 0 0 ;
        }
        margin-left: 30px;
        width: calc(100% - 30px);
    }
    .main-top{
            .main-top-btn{
        cursor: pointer;
        display: inline-block;
        height: 98%;
        line-height: 70px;
        margin: 0 40px 0 40px;

    }
    .main-active{
        border-bottom: 2px solid #3b90ff;
    }
        height: 70px;
        width: 100%;
       border-bottom: 1px dotted #3333;
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
    <div class="main-top">
        <div :class="{'main-top-btn': true, 'main-active': isBtn}" @click="isBtn = true">我学的课</div>
        <div :class="{'main-top-btn': true, 'main-active': !isBtn}" @click="isBtn = false">我学的课</div>
    </div>
    <ul class="main-container">
        <li class="one" v-for="item in dataList" :key="item.id">
            <router-link :to="'/CourseDetail/' + `${item.role === 1 ? 'tearch' : 'student'}/` + `${item.id}`">
            <img src="@/assets/pic/ce2acc035bc2116e4f096ac1b9ff1a05.jpg">
            <h3>{{item.name}}</h3>
            </router-link>

        </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'couresIndex',
  data () {
    return {
      isBtn: true,
      dataList: [
        { id: 1, name: '数字逻辑', url: '@/assets/pic/20200729133847_jdvhc.jpg', role: 1 },
        { id: 2, name: '数字逻辑', url: '@/assets/pic/20200729133847_jdvhc.jpg', role: 0 },
        { id: 1, name: '数字逻辑', url: '@/assets/pic/20200729133847_jdvhc.jpg', role: 1 },
        { id: 1, name: '数字逻辑', url: '@/assets/pic/20200729133847_jdvhc.jpg', role: 0 }
      ]
    }
  }
}
</script>

<style scoped lang="less">
.main-wrap{
    // 内容
    .main-container{
        .one{
            h3{
                margin: 10px  0 0 0;
            }
            display: inline-block;
            img{
                width: 100%;
                height: 130px;
                border-radius: 10px;
            }
            width: 240px;
            height: 300px;
            // background-color: red;
            margin:0 40px 0 0 ;
        }
        margin-left: 30px;
        width: calc(100% - 30px);
    }
    .main-top{
            .main-top-btn{
        cursor: pointer;
        display: inline-block;
        height: 98%;
        line-height: 70px;
        margin: 0 40px 0 40px;

    }
    .main-active{
        border-bottom: 2px solid #3b90ff;
    }
        height: 70px;
        width: 100%;
       border-bottom: 1px dotted #3333;
    }
    width: 100%;
    margin-top:10px;
    border-radius: 10px;
    background-color: #f2f4f7;
}
</style>
>>>>>>> d7dd708bb09340aabbbe4f3d8911b57d9a48194a
