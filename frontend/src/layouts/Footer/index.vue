<script setup>
import Container from '../Container/index.vue'
import {getItemListApi, getSpeciesApi} from '@/services/modules/index.js'
import { useRouter } from 'vue-router';
import {ref, onMounted} from 'vue'

const data1 = ref([])
const router = useRouter()
onMounted(async () => {


  for (let i = 1; i <= 7; i++) {
    const res = await getSpeciesApi(); // 假设getSpeciesApi是一个异步函数来获取数据
    data1.value.push(res);//为啥都是26
  }

  console.log(data1.value)
})

const handleClick = (name) => {
  router.push({ name: 'listDisplay', params: { name }});
}
const data = {
  total: "116M",
  children: []
}
let dataList = ref([])
async function getItemList() {
  const res = await getItemListApi();
  dataList.value = res['data']
}
onMounted(() => {
  getItemList()
})
</script>

<template>
  <div class="foot">
    <Container>
      <div class="foot-container">
        <div class="textarea" v-for="item in dataList" :key="item.name" @click="handleClick(item.name)">


          <div class="text">{{ item.value }}</div>
          <div class="name">{{ item.name }}</div>


        </div>

        <div class="totalTextarea">

          <div class="text">{{ data.total }}</div>
          <div class="name">总体</div>
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

  height: 120px;
  display: flex;
  justify-content: left;
  align-content: center;


  .textarea {

    display: flex;
    flex-direction: row;
    align-items: baseline;

    margin-right: 2em;

    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen, Oxygen-Sans, Ubuntu, Cantarell, "Fira Sans", "Droid Sans", "Helvetica Neue", "Source Sans Pro", sans-serif;

    cursor: pointer;

    .text {
      font-weight: 200;
      font-size: 3em;
      line-height: 2em;


    }

    .name {
      font-size: 1em;
      padding-left: 0.5em;
      line-height: 2em;
    }

  }


  .totalTextarea {
    margin-left: auto; /* 靠右，自动占据剩余空间 */
    display: flex;
    justify-content: right;
    flex-direction: row;
    align-items: baseline;


    padding-right: 2em;

    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen, Oxygen-Sans, Ubuntu, Cantarell, "Fira Sans", "Droid Sans", "Helvetica Neue", "Source Sans Pro", sans-serif;

    .text {
      font-weight: 200;
      font-size: 3em;
      line-height: 2em;
    }

    .name {
      font-size: 1em;
      padding-left: 0.5em;
      line-height: 2em;
    }


    &::before {
      content: "";
      width: 1px;
      height: 60px;
      background-color: #ccc; /* 灰色 */
      margin-right: 25px; /* 左边距离 */
    }

  }


}
</style>
