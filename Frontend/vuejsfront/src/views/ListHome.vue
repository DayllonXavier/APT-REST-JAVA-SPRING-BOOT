<template>
    <div className="App">
        <FilterSearch @apply-search="handleSearch" />
        <ListUsers :users="users" />
    </div>
</template>

<script>
import FilterSearch from '@/components/FilterSearch.vue';
import ListUsers from '@/components/ListUsers.vue';
import api from '../config/api.js';

export default {
    name: 'ListHome',
    components: {
        FilterSearch,
        ListUsers
    },
    data(){
        return {
            filter: '',
            users: {}
        }
    },
    mounted(){
        this.filter = '';
        this.getUsuarios();
    },
    methods: {
        getUsuarios(){
            api
            .get(`usuarios?filtro=${this.filter}`)
            .then((response) => {
                this.users = response.data;
            })
            .catch((err) => {
                console.error("Ocorreu um erro! " + err);
            });
        },
        handleSearch(filterValue){
            this.filter = filterValue;
            this.getUsuarios();
        }
    }
}
</script>

<style src="../assets/all.css"></style>