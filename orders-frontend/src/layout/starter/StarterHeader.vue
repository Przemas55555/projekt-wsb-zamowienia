<template>
    <header class="header-global sticky-top">
        <base-nav class="navbar-main navbar-dark" transparent type="" effect="light" expand>
            <ul class="navbar-nav navbar-nav-hover align-items-lg-center">
                <li class="nav-item">
                    <router-link to="/products" class="nav-item btn btn-warning">Produkty</router-link>
                    <router-link to="/orders" class="nav-item btn btn-warning">Zamówienia</router-link>
                </li>
            </ul>
        </base-nav>
    </header>
</template>
<script>
import BaseNav from "@/components/BaseNav";
import CloseButton from "@/components/CloseButton";

export default {
  components: {
    BaseNav,
    CloseButton
  }
};
</script>
<style>
</style>
