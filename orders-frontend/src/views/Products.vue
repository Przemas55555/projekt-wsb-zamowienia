<template>
    <div>
        <div class="position-relative">
            <section class="section-shaped my-0">
                <div class="shape shape-style-1 shape-default shape-skew">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
                <div class="container shape-container d-flex pt-lg-md">
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
                            <td><input type="number" pattern="[0-9]" step="1" max="10000" v-model.number="product.count" v-on:change="updatePrices()"
                                       v-on:keyup="updatePrices()"/></td>
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
                        <tr>
                            <td colspan="4">Miasto dostawy</td>
                            <td colspan="3"><input type="text" v-model="order.destinationCity"/></td>
                        </tr>
                        <tr>
                            <td colspan="4">Kod pocztowy dostawy</td>
                            <td colspan="3"><input type="text" pattern="[0-9][0-9]-[0-9][0-9][0-9]" v-model="order.destinationPostCode"/></td>
                        </tr>
                        <tr>
                            <td colspan="4">Adres dostawy</td>
                            <td colspan="3"><input type="text" v-model="order.destinationStreet"/></td>
                        </tr>
                        <tr>
                            <td colspan="4"></td>
                            <td colspan="3">
                                <button type="button" class="btn btn-success" v-on:click="createOrder">Zatwierdz zamowienie</button>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </section>
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "Products.vue",
        template: "Pobieranie listy produktów",
        data: function () {
            return {
                order: {
                    destinationCity: "",
                    destinationPostCode: "",
                    destinationStreet: "",
                    orderLines: [],
                },
                products: [],
                priceNettTotal: 0,
                priceGrossTotal: 0,
            }
        },
        mounted() {
            axios
                .get('http://localhost:8080/product')
                .then(response => {
                    this.products = response.data;
                    this.products.forEach(function (product) {
                        product.count = 0;
                        product.priceNettTotal = 0;
                        product.priceGrossTotal = 0;
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
                    sumNet += product.priceNettTotal;
                    sumGross += product.priceGrossTotal;
                });
                this.priceNettTotal = sumNet;
                this.priceGrossTotal = sumGross;
                this.order.orderLines = this.products;
            },
            createOrder: function () {
                let orderLines = [];
                this.products.forEach(function (product) {
                    orderLines.push({
                        product: {
                            id: product.id
                        },
                        order: null,
                        count: product.count,
                    });
                });
                this.order.orderLines = orderLines;
                axios
                    .post('http://localhost:8080/order', this.order)
                    .then(response => {
                        window.alert("Zamowienie przyjete");
                    });
            },
            formatPrice(value) {
                let val = (value / 100).toFixed(2).replace('.', ',')
                return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
            }
        }
    }
</script>

<style scoped>
    td input {
        width: 100%;
    }

</style>
