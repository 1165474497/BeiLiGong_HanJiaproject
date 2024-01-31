<script setup>
import {ref, onMounted} from "vue";
import {onBeforeRouteUpdate, useRoute} from "vue-router";
import {getMaterialListPageApi, getMaterialTotalApi} from "@/services/modules/index.js";
import ItemCard from "@/components/chemistryList/ItemCard.vue";

const {params} = useRoute();
let typeId = ref(params.id);
let data= ref({
  chemistryList: []
})


async function getChemistryList(){
  const res = await getMaterialListPageApi(typeId.value,page.value,pageSize.value);
  data.value.chemistryList = res.data;
}
onMounted(()=>{
  getChemistryList()
})
let page = ref(1);
let pageSize = ref(5)
let total = ref(0)

async function getMaterialTotal(id) {
  let res = await getMaterialTotalApi(id);
  total.value = res.data;
}

onMounted(()=>{
  getMaterialTotal(typeId.value)
})
let handleSizeChange = (val) => {
  pageSize.value = val;
  getChemistryList()
}
let handleCurrentChange = (val) => {
  page.value = val;
  getChemistryList()
}
onBeforeRouteUpdate((to, from, next) => {
  typeId.value = to.params.id;
  getChemistryList()
  getMaterialTotal(typeId.value)
  next()
})
</script>

<template>
   <el-scrollbar ref="scroll" class="chemistry-list">
     <h1 v-if="data.chemistryList.length===0" style="text-align: center;margin-top: 20px ">暂无数据</h1>
     <div v-else style="text-align: center;margin-top: 20px">共有{{total}}条数据</div>

     <ItemCard v-model:itemList="data.chemistryList"></ItemCard>
     <el-pagination
         class="item-pagination"
         v-model:current-page="page"
         v-model:page-size="pageSize"
         :page-sizes="[5, 10]"
         layout="total, sizes, prev, pager, next, jumper"
         :total="total"
         @size-change="handleSizeChange"
         @current-change="handleCurrentChange"
         :hide-on-single-page="true"
     />
   </el-scrollbar>
</template>

<style>
.el-pagination {
  justify-content: center;
  margin-bottom: 50px;
}
</style>