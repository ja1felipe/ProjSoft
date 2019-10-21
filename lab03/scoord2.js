class Disciplina {
    constructor(id, nome, creditos, pre){
        this._id = id;
        this._nome = nome;
        this._creditos = creditos;
        this._pre = pre;
    }

    get_nome() {
        return this._nome;
    }

    set_nome(nome){
        this._nome = nome;
        return true;
    }

    get_id(){
        return this._id;
    }
}

class Turma{
    constructor(disciplina, periodo){
        this._disc = disciplina;
        this._periodo = periodo;
        this._estudantes = new Array();
        this._professor = null;
        this._status = undefined;
    }

    get_disciplina(){
        return this._disc;
    }

    get_periodo(){
        return this._periodo
    }

    set_status(status){
        if(status !== "planejada" && status !== "ativa" && status !== "concluída"){
            console.log("New Status inválido")
            return false;
        }else{
            this._status = status;
            return true;
        }
    }

    get_status(){
        return this._status;
    }

    matricular(matricula){
        if(!this._estudantes.includes(matricula)){
            this._estudantes.push(matricula);
            return true;
        }
        return false;
    }

    set_professor(professor){
        this._professor = professor;
    }

    get_professor(){
        return this._professor;
    }

    get_estudantes(){
        return this._estudantes;
    }

}

function Pessoa(matricula, nome, email, cpf, url){
    let _matricula = matricula;
    let _nome = nome;
    let _email = email;
    let _cpf = cpf;
    let _url = url;
    let _turmas = new Array();
    let pessoa = {

        get_turma: () => _turmas,
        get_matricula: () => _matricula,
        get_nome: () => _nome,
        get_cpf: () => _cpf,
        get_email: () => _email,
        get_cpf: () => _cpf,
        get_url: () => _url,
        set_nome: nome => (_nome = nome),
        set_email: (email) => _email = email,
        set_url: (url) => _url = url,
        turmas: semestre => {
            let retorno = new Array();
            _turmas.forEach(turma => {
                if (turma.get_periodo() === semestre) {
                    retorno.push(turma);
                }
            });
            return retorno;
        }

    }
    return pessoa;
}

function Estudante(matricula, nome, email, cpf, url){
    let estudante = new Pessoa(matricula, nome, email, cpf, url);
    estudante.matricula = (turma) => estudante.get_turma().push(turma)
    return estudante;
}

function Professor(matricula, nome, email, cpf, url){
    let professor = new Pessoa(matricula, nome, email, cpf, url);
    professor.matricula = (turma) => professor.professorurma().push(turma)
    return professor;
}

module.exports = {
    disciplina: Disciplina,
    turma: Turma,
    estudante: Estudante,
    professor: Professor
};