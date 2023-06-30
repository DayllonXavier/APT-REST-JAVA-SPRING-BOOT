<template>
    <div className="filterSearch">
        <form @submit="handleSearch($event)">
            <input type="text" placeholder="Digite..." v-model="filter">
            <button type="submit">Buscar</button>
        </form>
    </div>
</template>

<script>
export default {
    name: 'FilterSearch',
    data() {
        return {
            filter: ''
        }
    },
    emits: ['applySearch'],
    methods: {
        handleSearch(e){
            e.preventDefault();
            this.$emit('applySearch', this.filter);
        }
    }
}
</script>
