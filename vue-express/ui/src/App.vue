<template>
    <router-view></router-view>
</template>

<script>
export default {
    name: "App",
    components: {
        Home: () => import("./views/Home.vue")
    },
}
</script>

<style>
body {
    margin: 0;
}
* {
    font-family: "Trebuchet MS";
}
</style>
