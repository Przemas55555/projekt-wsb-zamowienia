import Vue from "vue";
import Router from "vue-router";
import StaterHeader from "./layout/starter/StarterHeader";
import StarterFooter from "./layout/starter/StarterFooter";
import Products from "./views/Products";
import Orders from "./views/Orders"
import Landing from "./views/Landing"

Vue.use(Router);

export default new Router({
    linkExactActiveClass: "active",
    routes: [
        {
            path: "/",
            name: "homepage",
            components: {
                header: StaterHeader,
                default: Landing,
                footer: StarterFooter
            },

        },
        {
            path: "/products",
            name: "products",
            components: {
                header: StaterHeader,
                default: Products,
                footer: StarterFooter
            },
        }, {
            path: "/orders",
            name: "Order",
            components: {
                header: StaterHeader,
                default: Orders,
                footer: StarterFooter
            }
        }

    ],
    scrollBehavior: to => {
        if (to.hash) {
            return {selector: to.hash};
        } else {
            return {x: 0, y: 0};
        }
    }
});
