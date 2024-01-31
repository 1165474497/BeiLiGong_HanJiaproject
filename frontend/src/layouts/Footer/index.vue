<script setup>
import Container from '../Container/index.vue'
import {getItemListApi, getTotalApi} from '@/services/modules/index.js'
import {useRouter} from 'vue-router';
import {ref, onMounted} from 'vue'

const router = useRouter()

const handleClick = (name) => {
  router.push({name: 'listDisplay', params: {name}});
}
const data = ref({

  total: "",
  children: []
})

async function getItemList() {
  const res = await getItemListApi();
  data.value.children = res['data']
}

async function getTotal() {
  const res = await getTotalApi();
  console.log(res)
  data.value.total = res['data']
}

onMounted(() => {
  getItemList()
  getTotal()
})
</script>

<template>
  <div class="foot">
    <Container>
      <div class="foot-container">
        <div v-for="item in data.children" class="statistics">
          <div class="s-value">{{ item.value }}</div>
          <div class="s-name">{{ item.name }}</div>
        </div>
        <div class="s-divider">
          <el-divider border-style="solid" direction="vertical"></el-divider>
        </div>
        <div class="statistics">
          <div class="s-value">{{data.total}}</div>
          <div class="s-name">总计</div>
        </div>
      </div>
    </Container>
  </div>
</template>

<style scoped>
.foot {
  //background: url('@/assets/4.jpg') no-repeat center/150%; background-color: rgb(241, 241, 241); max-height: 150px; box-shadow: 0 -10px 20px rgba(0, 0, 0, .2);

}

.foot-container {

  height: 80px;
  display: grid;
  grid: repeat(1, 1fr) / repeat(8, 1fr);

  .statistics {
    margin-top: 20px;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    .s-name{
      margin-left: 5px;
      margin-top: 15px;
    }
    .s-value{
      font-size: 36px;
      font-family: "Calibri Light",serif;
    }
  }
  .s-divider{
    .el-divider{
      margin-left: 30px;
      height: 100%;
    }
  }

}
</style>
