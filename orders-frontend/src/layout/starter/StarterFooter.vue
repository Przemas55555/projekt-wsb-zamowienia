<template>
    <footer class="footer">
        <div class="row align-items-center justify-content-md-between">
            <div class="col-md-6">
                <div class="copyright">
                    &copy; {{year}}
                    <a href="https://www.anonimowyprogramista.pl" target="_blank" rel="noopener">Przemysław Kaczmarczyk</a>
                </div>
            </div>
        </div>
    </footer>
</template>
<script>
    export default {
        name: 'starter-footer',
        data() {
            return {
                year: new Date().getFullYear()
            }
        }
    };
</script>
<style>
</style>
