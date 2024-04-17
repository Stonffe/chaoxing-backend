<template>
  <div class="course-main">
    <div class="left-nav">
        <img src="@/assets/pic/ce2acc035bc2116e4f096ac1b9ff1a05.jpg">
        <ul>
            <li v-for="item in list" :key="item.id">
                <router-link :to="item.url"><i :class="item.icon"></i>{{item.name}}</router-link>
            </li>
        </ul>

    </div>
    <div class="right-main">
        <div class="container">
            <div class="top"><p></p>已完成任务点:<h4>{{data.over}}</h4> / {{data.totle}}</div>
            <!--  -->
           <div class="context">
             <div class="title">目录</div>
            <div>
                <ul class="list">
                    <li v-for="item in dataList" :key="item.id">
                        <router-link :to="`${item.id}`">
                        <i :class="{'el-icon-success' : item.isover === 1}" v-if="item.isover === 1"></i>
                        <i :class="{'el-icon-info' :  true, active: true}" v-else></i>
                        {{item.id}}.{{item.name}}
                        </router-link>
                        </li>

                </ul>
            </div>
           </div>

        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CourseIndex',
  data () {
    return {
      list: [
        { id: 1, name: '章节', url: 'Coures', icon: 'el-icon-s-home' },
        { id: 2, name: '视频', url: 'PersonCenter', icon: 'el-icon-user-solid' },
        { id: 3, name: '文件', url: 'file', icon: 'el-icon-user-solid' }
      ],
      data: {
        totle: 70,
        over: 2
      },
      dataList: [
        { id: 1, name: '增强信心底气 感受中国经济发展新动能新亮点', isover: 1 },
        { id: 2, name: '贯彻“五个必须” 做好新时代经济工作（上）', isover: 0 }
      ]
    }
  }
}
</script>

<style scoped lang="less">
.context{
    margin:20px 0 0 40px;
    .title{
        color: #A8A8B3;
    }
    .list{
        li{
            margin-bottom: 10px;
            p{
                display: inline-block;

            }
           i{
            color:#00B368;
           }
           .active{
            color: #ffb04e;
           }
        }
    }
}
.right-main {
    .container {
            background-color: #f2f4f7;
            border-radius: 10px;
        .top {
            h4{
            display: inline-block;
            font-size: 14px;
            color: #00B368;
            font-weight: bold;
            margin-left:10px
            }
            p{
                display: inline-block;
                width: 20px;;
                height: 20px;
                border-radius: 20px;
                background: #ffb04e;
                margin-right: 20px;
            }
            line-height: 20px;
            padding: 8px 0;
            font-size: 14px;
            color: #646873;
            font-weight: bold;
        }
        width: 80%;
        margin: 30px;

        border-bottom: 1px dotted #3333;

    }
    width: calc(100% - 180px);
    margin-left:180px;

}
.left-nav{
    img{
        width: 100%;
        height: 110px;
    }
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
