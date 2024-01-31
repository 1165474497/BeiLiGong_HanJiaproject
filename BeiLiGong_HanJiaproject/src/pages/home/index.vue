<script setup>
import Container from '@/layouts/Container/index.vue'
import {ref} from 'vue'
import {Search} from '@element-plus/icons-vue'

const serchText =ref('')


</script>

<template>
  <div class="backGroundBox">


    <div class="platformNamePart">
      <h2 class="Name">数据管理平台</h2>
      <i class="fa-light fa-atom-simple"></i>
      <!--        <el-input-->
      <!--            v-model="input2"-->
      <!--            class="searchText"-->
      <!--            placeholder="Please Input"-->
      <!--            :prefix-icon="Search"-->
      <!--        />-->
      <!--        <template #append>-->
      <!--          <el-button :icon="Search" />-->
      <!--        </template>-->

      <el-input
          v-model="serchText"
          placeholder="Please input"
          class="searchText"
          size="large"

      >
<!--        <template #prepend>-->
<!--&lt;!&ndash;          <el-select v-model="select" placeholder="Select" style="width: 115px">&ndash;&gt;-->
<!--&lt;!&ndash;            <el-option label="Restaurant" value="1"/>&ndash;&gt;-->
<!--&lt;!&ndash;            <el-option label="Order No." value="2"/>&ndash;&gt;-->
<!--&lt;!&ndash;            <el-option label="Tel" value="3"/>&ndash;&gt;-->
<!--&lt;!&ndash;          </el-select>&ndash;&gt;-->
<!--        </template>-->
        <template #append>
          <el-button :icon="Search " style="font-size: 24px;"/>
        </template>
      </el-input>
    </div>

  </div>
</template>

<style scoped>

.backGroundBox {
  height: 100%;
  width: 100%;
  //background: RGB(32, 85, 138) url('@/assets/indexPic/background.png') no-repeat center;
  background: linear-gradient(to bottom,rgba(32,84,147,.5),rgba(17,46,81,.5)),url('@/assets/indexPic/background.png'),linear-gradient(to bottom,#20558a,#112e51);

  background-size: cover;

  .platformNamePart {

    align-items: center;
    flex-direction: column; /* 将子元素垂直排列 */
    height: 100%;

    position: relative;
    text-align: center;


    .Name {
      font-family: Roboto, sans-serif;
      text-align: center;
      font-size: 5em;
      font-weight: 400;
      margin: 0;
      letter-spacing: 15px; /* 调整字符之间的间距，可以根据需要进行更改 */
      padding-bottom: 40px;
      color: white;
    }

    .input-with-select .el-input-group__prepend {
      background-color: var(--el-fill-color-blank);
    }

    .searchText {
      width: 50%;
      margin-top: 50px;



    }

    .searchText /deep/ .el-input__inner {/*改输入框大小*/
      font-size: 40px;
      height: 80px;
    }
  }

}
</style>