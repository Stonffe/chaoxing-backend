<<<<<<< HEAD
<template>
  <div class="course-main">
    <div class="left-nav">
        <ul>
            <li v-for="item in list" :key="item.id">
                <router-link :to="item.url"><i :class="item.icon"></i>{{item.name}}</router-link>
            </li>
        </ul>

    </div>
    <div></div>
  </div>
</template>

<script>
export default {
  name: 'CourseIndex',
  data () {
    return {
      list: [
        { id: 1, name: '视频', url: 'Coures', icon: 'el-icon-s-home' },
        { id: 2, name: '题型', url: 'PersonCenter', icon: 'el-icon-user-solid' }
      ]
    }
  }
}
</script>

<style scoped lang="less">
.left-nav{
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
    position: fixed;
    left:0;
    top:70px;
    bottom:0;
    background-color: #ffffff;
    width: 180px;
    box-shadow: 1px 5px 5px #888888;

}
</style>
=======
<template>
  <div class="course-main">
    <div class="left-nav">
        <ul>
            <li v-for="item in list" :key="item.id">
                <router-link :to="item.url"><i :class="item.icon"></i>{{item.name}}</router-link>
            </li>
        </ul>

    </div>
    <div></div>
  </div>
</template>

<script>
export default {
  name: 'CourseIndex',
  data () {
    return {
      list: [
        { id: 1, name: '视频', url: 'Coures', icon: 'el-icon-s-home' },
        { id: 2, name: '题型', url: 'PersonCenter', icon: 'el-icon-user-solid' }
      ]
    }
  }
}
</script>

<style scoped lang="less">
.left-nav{
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
    position: fixed;
    left:0;
    top:70px;
    bottom:0;
    background-color: #ffffff;
    width: 180px;
    box-shadow: 1px 5px 5px #888888;

}
</style>
>>>>>>> d7dd708bb09340aabbbe4f3d8911b57d9a48194a
