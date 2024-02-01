<script setup>
import {defineModel} from "vue";
import router from "@/routers/index.js";
let typeList = defineModel()
</script>

<template>
  <div class="type-info-card">
    <el-card @click="router.push(`/materialList/${item.id}`)" v-for="item in typeList" :header="item.name">
      <el-statistic :value="Number(item.value)" ></el-statistic>
      <el-button @click="router.push(`/materialList/${item.id}`)" link>查看详情</el-button>
    </el-card>
  </div>
</template>

<style>
  .type-info-card{
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    .el-card{
      width: 30%;
      margin-top: 20px;
      border: 5px solid #e6e1e1;
      padding: 20px;
      background-color: #ffffff;
      font-weight: bold;

      transition: background-color 1s;
      .el-card__header{
        font-size: 20px;
      }
      .el-statistic{
        font-size: 30px;
      }
      .el-button{
        font-size: 17px;
        margin-top: 10px;

      }
      &:hover {
        background-color: #e6e1e1;

      }

    }


  }
</style>