<script setup>
import router from "@/routers/index.js";

let data = defineModel("itemList")
import {BASE_URL} from "@/services/request/config.js";
</script>

<template>
  <div class="item-list">
    <div class="item-list-card" v-for="item in data">
      <div class="item-image">
        <el-image :src="BASE_URL+`/static/diagram/${item['cas']}.png`" fit="fill">
          <template #error>
            <el-empty :image-size="100" description="暂无图片"></el-empty>
          </template>
        </el-image>

      </div>
      <div class="item-info">
        <el-descriptions
          :bordered="true"
          :column="1"
          @click="router.push(`/material/${item['cas']}`)"
          :title="item['name_cn']"
        >
          <template #title>
            <span class="custom-title-style">{{ item['name_cn'] }}</span>
          </template>
          <el-descriptions-item label="名称:">{{item['name_zh']}}</el-descriptions-item>
          <el-descriptions-item label="CAS号:">{{item['cas']}}</el-descriptions-item>
          <el-descriptions-item label="材料种类:">{{item['material_type']}}</el-descriptions-item>
          <el-descriptions-item label="简称:">{{item['abbreviation']}}</el-descriptions-item>
          <el-descriptions-item label="分子式:">{{item['molecular_formula']}}</el-descriptions-item>
          <el-descriptions-item label="分子量:">{{item['molecular_weight']}}</el-descriptions-item>
        </el-descriptions>
        <el-button  link @click="router.push(`/material/${item['cas']}`)">查看更多</el-button>
      </div>

    </div>
  </div>

</template>

<style>
.item-list-card{
  background: #ffffff;
  margin: 0 auto 2% auto;
  width: 60%;
  box-shadow: 0 2px 2px 0 rgba(0,0,0,.16), 0 0 0 1px rgba(0,0,0,.08);

  border: solid 1px #d6d7d9;
  border-radius: 2px;
  display: flex;
  flex-wrap: wrap;
  padding: 25px;
  justify-content: flex-start;

  .item-image{
    border: 2px solid transparent; /* 添加透明的边框来稳定尺寸 */
    transition: border-color 0.3s;
    &:hover{
      border: 2px solid #d6d7d9;
    }

  }

  .el-image{


    height: 100px;



  }
  .item-info{
    width: 70%;
    margin-left: 20px;

    .custom-title-style {
      color: rgb(0,113,188); /* 设置标题字体颜色为蓝色 */
      cursor: pointer; /* 设置鼠标悬停时光标为指针 */
    }

    .custom-title-style:hover {
      color: rgb(32,85,138);
    }

    .el-descriptions__label{
      font-weight: bold;
    }



  }
}
</style>