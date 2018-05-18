//#include<stdlib.h>
//#include<stdio.h>
//
//#include"macro/LinkedListNode.h"
//#include"macro/LinkedList.h"
//
//int main()
//{
//
//    LinkedList *linkedList = new_LinkedList();
//
//    linkedList->vt->push(linkedList, 1, sizeof(int));
//    linkedList->vt->push(linkedList, 5, sizeof(int));
//    linkedList->vt->push(linkedList, 10, sizeof(int));
//
//    Node *currentNode = linkedList->nodes;
//
//    if(currentNode != NULL)
//    {
//        printf(currentNode->data);
//        while(currentNode->next != NULL)
//        {
//            currentNode = currentNode->next;
//            printf(currentNode->data);
//        }
//    }
//
//    #ifdef __WIN32__
//        system("PAUSE");
//    #endif
//        return 0;
//}