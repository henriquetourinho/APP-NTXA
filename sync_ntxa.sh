#!/bin/bash

# Diretório do projeto
cd /root/AndroidStudioProjects/NTXA/

# Adiciona todas as mudanças (se houver alguma)
git add .

# Cria um commit automático se houver mudanças pendentes
# Verifica se há algo para commitar antes de executar o commit
if ! git diff-index --quiet HEAD --; then
    git commit -m "Auto Sync - $(date +'%Y-%m-%d %H:%M:%S')"
fi

# Envia as mudanças para o GitHub no ramo 'main'
# Ele usará as credenciais salvas pelo GCM que configuramos anteriormente.
git push origin main

# Fim do script