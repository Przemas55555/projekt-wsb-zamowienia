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
                            <th>Ilość produktów</th>
                            <th>Cena netto</th>
                            <th>Cena Brutto</th>
                            <th>Misto Dostawy</th>
                            <th>Kod pocztowy</th>
                            <th>Adres Dostawy</th>
                            <th>Starus</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="order in orders">
                            <td>{{order.id}}</td>
                            <td>{{order.productCount}}</td>
                            <td>{{formatPrice(order.priceNettTotal)}}</td>
                            <td>{{formatPrice(order.priceGrossTotal)}}</td>
                            <td>{{order.destinationCity}}</td>
                            <td>{{order.destinationPostCode}}</td>
                            <td>{{order.destinationStreet}}</td>
                            <td>Zamówione</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "Orders.vue",
        template: "Pobieranie listy zamówień",
        data: function () {
            return {
                orders: [],
            }
        },
        mounted() {
            axios
                .get('http://localhost:8080/order')
                .then(response => {
                    this.orders = response.data;
                    this.orders.forEach(function (order) {
                        let sumNet = 0;
                        let sumGross = 0;
                        let productCount = 0;
                        order.orderLines.forEach(function (orderLine) {
                            sumNet += orderLine.product.priceNett * orderLine.count;
                            sumGross += orderLine.product.priceGross * orderLine.count;
                            productCount += orderLine.count;
                        });
                        order.priceNettTotal = sumNet;
                        order.priceGrossTotal = sumGross;
                        order.productCount = productCount;
                    })
                });
        },
        methods: {
            formatPrice(value) {
                let val = (value / 100).toFixed(2).replace('.', ',')
                return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
            }
        }
    }
</script>

<style scoped>

</style>
