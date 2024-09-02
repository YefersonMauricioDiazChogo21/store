const guardar=document.querySelector('#save')
const agregarTraje=document.querySelector('#newSuit')
const divTrajes=document.querySelector('.trajes-nuevos')
const eliminarTraje=document.querySelector('#eliminar')

const hero={
    nombrePersonaje:'',
    nombreActor:'',
    edad:0,
    ciudad:'',
    poster:'',
    franquisia:{},
    trajes:[]
}

const personaje=hero



guardar.addEventListener('click',()=>{
    const  form= document.querySelector('#formHeros')
    const  datos= Object.fromEntries(new FormData(form).entries())
    const  personaje= JSON.parse(JSON.stringify(datos));
    const {nombrePersonaje,nombreActor,edad,ciudad,poster,franquisia:{},...otro}=personaje
    personaje.nombrePersonaje=nombrePersonaje
    personaje.nombreActor=nombreActor
    personaje.edad=edad
    personaje.poster=poster

    console.log({nombrePersonaje,nombreActor,edad,ciudad,poster,franquisia:{},...otro})

})
agregarTraje.addEventListener('click', (e) => {
    let id = Date.now().toString(16);
    formTraje=`
    <div id='traje${id}>'
        <div class="col-md-4">
            <label for="nombreTraje${id}" class="form-label">Traje</label>
            <input type="text" class="form-control" id="nombreTraje${id}"  name="nombreTraje${id}" value="" required>
        </div>
        <div class="col  position-relative">
        <button type="button" class="btn btn-danger position-absolute bottom-0 end-0" data-id="${id}" id='eliminar' name="eliminar">-</button>
        </div>
    </div>
    `
    divTrajes.insertAdjacentHTML('beforeend',formTraje);
    
 
});
divTrajes.addEventListener('click',(e)=>{
    console.log(e.id)
    if(e.target.name=='eliminar'){
        let id = e.target.dataset.id
        console.log(id)
        let traje=document.querySelector(`#traje${id}`)
        console.log(traje)
        traje.parentNode.removeChild(traje)
    }
    
})