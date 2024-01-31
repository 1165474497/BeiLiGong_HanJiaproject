<template>

  <div class="wrap">

    <Header/>
    <div class="mist-app">
      <router-view></router-view>
    </div>

    <Footer />
  </div>


</template>

<script setup>
import Footer from './layouts/Footer/index.vue'
import Header from './layouts/Header/index.vue'
</script>

<style scoped>
.wrap {
  display: flex;
  flex-direction: column;
  height: 100vh;
}


.mist-app {
  flex: 1

}
</style>
