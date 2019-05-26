<template>
    <div class="container pt-lg-md" >
        <table class="table table-dark table-striped" id="Products">
            <thead>
            <tr>
                <th>#</th>
                <th>Nazwa</th>
                <th>Cena netto</th>
                <th>Cena Brutto</th>
                <th>Ilosć</th>
                <th>Netto razem</th>
                <th>Brutto razem</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="product in products">
                <td>{{product.id}}</td>
                <td>{{product.name}}</td>
                <td>{{formatPrice(product.priceNett)}}</td>
                <td>{{formatPrice(product.priceGross)}}</td>
                <td><input type="number" pattern="[0-9]" step="1" max="10000" v-model.number="product.count" v-on:change="updatePrices()" v-on:keyup="updatePrices()"/></td>
                <td>{{formatPrice(product.priceNettTotal)}}</td>
                <td>{{formatPrice(product.priceGrossTotal)}}</td>
            </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5">Razem do zapłaty</td>
                    <td>{{formatPrice(priceNettTotal)}}</td>
                    <td>{{formatPrice(priceGrossTotal)}}</td>
                </tr>
            </tfoot>
        </table>
        <button
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "Products.vue",
        template: "Pobieranie listy produktów",
        data: function () {
            return {
                products: [],
                priceNettTotal: 0,
                priceGrossTotal: 0,
            }
        },
        mounted() {
            axios
                .get('http://localhost:8080/product')
                .then(response => {
                    this.products = response.data
                    this.products.forEach(function (element) {
                        element.count = 0;
                        element.priceNettTotal = 0;
                        element.priceGrossTotal = 0;
                    })
                });
        },
        methods: {
            updatePrices: function () {
                let sumNet = 0;
                let sumGross = 0;
                this.products.forEach(function (product) {
                    product.priceNettTotal = product.priceNett * product.count;
                    product.priceGrossTotal = product.priceGross * product.count;
                    sumNet+= product.priceNettTotal;
                    sumGross += product.priceGrossTotal;
                });
                this.priceNettTotal = sumNet;
                this.priceGrossTotal = sumGross;
            },
            createOrder: function () {

            },
            formatPrice(value) {
                let val = (value/100).toFixed(2).replace('.', ',')
                return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
            }
        }
    }
</script>

<style scoped>

</style>
