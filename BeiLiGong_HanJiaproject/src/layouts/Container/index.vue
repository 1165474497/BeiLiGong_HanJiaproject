<script setup>

</script>

<template>
  <div class="container">
    <slot />
  </div>
</template>

<style scoped>
.container {
  margin: 0 auto;
}

@media (min-width: 768px) {
  .container {
    width: 750px;
  }
}

@media (min-width: 992px) {
  .container {
    width: 970px;
  }
}

@media (min-width: 1200px) {
  .container {
    width: 1500px;
  }
}
</style>
