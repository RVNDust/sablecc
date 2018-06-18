//
// Created by RVNDu on 05/06/2018.
//



#include<stdlib.h>
#include<stdio.h>

#include "macro/Context.h"
#include "macro/Map.h"
#include"macro/MA.h"
#include"macro/MB.h"
#include"macro/MC.h"

int main()
{
    puts("===== DEBUT TEST MAP =====");
    map_str_t map_str;
    map_init(&map_str);

    char* str = map_get(&map_str, "splouf");
    if(str == NULL)
    {
        puts("NULL");
    }
    else
    {
        puts("OK_HAND");
    }
    puts("===== FIN TEST MAP =====");
    puts("===== DEBUT TEST INTERNALS =====");

    MA *ma = new_MA();
    ma->vt->addX(ma, "First argument of MA");
    MB *mb = new_MB();
    mb->vt->addO(mb, "la");

    MC *mc = new_MC();
    mb->vt->addS(mb, new_MC());
    ma->vt->addZ(ma, new_MC());
    ma->vt->addY(ma, mb);
    ma->vt->addZ(ma, new_MC());

    puts(ma->vt->build(ma, &(ma->context)));

    puts("===== FIN TEST INTERNALS =====");

#ifdef __WIN32__
    system("PAUSE");
#endif
    return 0;
}