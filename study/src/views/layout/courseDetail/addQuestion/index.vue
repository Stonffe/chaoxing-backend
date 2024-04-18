<template>
  <div clas="wrap">
    <div class="top">
        <div class="save">
            <div @click="handleReturn()" class="myreturn">返回</div>
        </div>
        <div class="questionclass">
            <ul>
                <li>
                    <i class="el-icon-data-board"></i>
                    <div class="question-class">单选</div>
                </li>
                                <li>
                    <i class="el-icon-data-line"></i>
                    <div class="question-class">判断</div>
                </li>
            </ul>
        </div>
    </div>
    <div class="left-nav">
        <ul>
            <li v-for="item in dataList" :key="item.id">
                <div class="num">{{item.id}}.</div>
                <div class="list-title" @click="showQuestion(item.id)">{{item.name}}</div></li>
        </ul>
    </div>
    <div class="main">
        <div class="container">
            {{data.id}}.{{data.name}}<br/><br/>
            <!-- 选择 -->
            <div v-if="data.kind === 1">
                A.<input type="text" v-model="data.optionA"><br/><br/>
                B.<input type="text" v-model="data.optionB"><br/><br/>
                C.<input type="text" v-model="data.optionC"><br/><br/>
                D.<input type="text" v-model="data.optionD"><br/><br/>
                答案：<input type="text" v-model="data.answer">
                <div class="handlemodify">修改</div>
            </div>
            <div v-if="data.kind === 0">
                答案：<input type="text" v-model="data.answer">
                <div class="handlemodify">修改</div>
            </div>

        </div>

    </div>
  </div>
</template>

<script>
export default {
  name: 'addQuestion',
  data () {
    return {
      dataList: [
        { id: 1, name: '测试1213123123111111111111111111111111', kind: 0, optionA: 'AAAAAAAAA', optionB: 'BBBBBBBBBBB', optionC: 'CCCCCCCCCC', optionD: 'DDDDDDDDDDDDDDDDDDD', answer: '1' },
        { id: 2, name: '​测试1123123测试测试测试测试测试测试', kind: 1, optionA: 'AAAAAAAAA', optionB: 'BBBBBBBBBBB', optionC: 'CCCCCCCCCC', optionD: 'DDDDDDDDDDDDDDDDDDD', answer: 'B' }
      ],
      data: ''
    }
  },
  methods: {
    showQuestion (id) {
      console.log(id)
      this.data = this.dataList[id - 1]
      console.log(this.data)
    },
    handleReturn () {
      this.$router.go(-1)
    }
  },
  mounted () {
    console.log(1)
  }
}
</script>

<style scoped lang="less">
.main{
    .container {
        .handlemodify{
            background-color: #29a9a5;
            height: 40px;
            width: 80px;
            text-align: center;
            line-height: 40px;
            margin-top: 20px;
            border-radius: 10px;
            cursor: pointer;
        }
        margin: 10px 0 0 20px;
    }
     position: fixed;
    top:120px;
    left:calc(60% - 460px);
    bottom: 60px;
    width: 780px;
     margin-left: 80px;
     border-radius: 10px;
     border: 1px solid #3333;
}
.left-nav{
    ul{
        width: 100%;

        li{
            .num {
                display: inline-block;
                margin-left: 20px;
                height: 100%;
            }
            width: 100%;
            height: 30px;
            line-height: 30px;
            font-size: 12px;
            color: #333;
            border-bottom: 1px dotted #3333;
            cursor: pointer;
            .list-title{
                width: 200px;
                display: inline-block;
                margin-left: 40px;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 100%;
                line-height: 30px;
            }

        }
    }
    position: fixed;
    top:110px;
    bottom: 0;
    width: 300px;
    // background-color: red;
    border-right: 1px dotted #3333;
}
.top{
    .questionclass {
        height: 60px;
        display: flex;
        ul{
            height: 100%;
            width: 100%;
            display: flex;
            li{
                display: flex;
                flex-direction: column;
                justify-content: center;
                margin:0 20px 0 20px;
                i{

                    font-size: 40px;
                }
            }
            .question-class{
                font-size: 12px;
                margin-left:8px;
            }
        }
    }
    position: fixed;
    top:0;
    left:0;
    right:0;
    border-bottom: 1px dotted #3333;
    .save {
        position: relative;
        height: 50px;
        background-color: #f3f3f3;

        .myreturn{
        width: 50px;
        height: 20px;
        position: absolute;
        top: 20px;
        left:20px;
        border: 1px solid #3333;
        text-align: center;
        background-color: #ffff;
        font-weight: bold;
        cursor: pointer;
        }
    }
}
</style>
