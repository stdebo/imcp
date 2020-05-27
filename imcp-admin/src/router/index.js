import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/* Router Modules */
import componentsRouter from './modules/components'
import chartsRouter from './modules/charts'
import tableRouter from './modules/table'
import nestedRouter from './modules/nested'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    noCache: true                if set true, the page will no be cached(default is false)
    affix: true                  if set true, the tag will affix in the tags-view
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '/basicPlatform',
    component: Layout,
    redirect: 'noRedirect',
    name: 'BasicPlatform',
    meta: {
      title: '基础平台',
      icon: '404'
    },
    children: [
      {
        path: 'org',
        component: () => import('@/views/basic-platform/org'),
        name: 'OrgManagement',
        meta: { title: '机构管理', noCache: true }
      },
      {
        path: 'dept',
        component: () => import('@/views/basic-platform/dept'),
        name: 'DeptManagement',
        meta: { title: '部门管理', noCache: true }
      },
      {
        path: 'user',
        component: () => import('@/views/basic-platform/user'),
        name: 'UserManagement',
        meta: { title: '用户管理', noCache: true }
      },
      {
        path: 'role',
        component: () => import('@/views/basic-platform/role'),
        name: 'RoleManagement',
        meta: { title: '角色管理', noCache: true }
      },
      {
        path: 'authority',
        component: () => import('@/views/basic-platform/authority'),
        name: 'AuthManagement',
        meta: { title: '权限管理', noCache: true }
      }
    ]
  },
  {
    path: '/systemManagement',
    component: Layout,
    redirect: 'noRedirect',
    name: 'SystemManagement',
    meta: {
      title: '系统管理',
      icon: '404'
    },
    children: [
      {
        path: 'appsoft',
        component: () => import('@/views/system-management/appsoft'),
        name: 'AppsoftManagement',
        meta: { title: '应用环境', noCache: true }
      },
      {
        path: 'winform',
        component: () => import('@/views/system-management/winform'),
        name: 'WinformManagement',
        meta: { title: '窗口管理', noCache: true }
      },
      {
        path: 'menufunction',
        component: () => import('@/views/system-management/menufunction'),
        name: 'MenuFunManagement',
        meta: { title: '功能导航', noCache: true }
      }
    ]
  },
  {
    path: '/outputManagement',
    component: Layout,
    redirect: 'noRedirect',
    name: 'OutputManagement',
    meta: {
      title: '输出管理',
      icon: '404'
    },
    children: [
      {
        path: 'index',
        component: () => import('@/views/output-management/index'),
        name: 'Page401',
        meta: { title: '图表管理', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/output-management/index'),
        name: 'Page404',
        meta: { title: '消息管理', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/output-management/index'),
        name: 'Page404',
        meta: { title: '接口管理', noCache: true }
      }
    ]
  },
  {
    path: '/objManagement',
    component: Layout,
    redirect: 'noRedirect',
    name: 'ObjManagement',
    meta: {
      title: '数据对象',
      icon: '404'
    },
    children: [
      {
        path: 'objects',
        component: () => import('@/views/obj-management/objects'),
        name: 'Objects',
        meta: { title: '对象管理', noCache: true }
      },
      {
        path: 'fields',
        component: () => import('@/views/obj-management/fields'),
        name: 'Fields',
        meta: { title: '字段管理', noCache: true }
      },
      {
        path: 'fieldRule',
        component: () => import('@/views/obj-management/fieldRule'),
        name: 'FieldRule',
        meta: { title: '规则字段', noCache: true }
      },
      {
        path: 'dataDict',
        component: () => import('@/views/obj-management/dataDict'),
        name: 'DataDict',
        meta: { title: '数据字典', noCache: true }
      }
    ]
  },
  {
    path: '/workflowManagement',
    component: Layout,
    redirect: 'noRedirect',
    name: 'WorkflowManagement',
    meta: {
      title: '工作流平台',
      icon: '404'
    },
    children: [
      {
        path: 'forms',
        component: () => import('@/views/workflow-management/forms'),
        name: 'Forms',
        meta: { title: '表单管理', noCache: true }
      },
      {
        path: 'workflows',
        component: () => import('@/views/workflow-management/workflows'),
        name: 'Workflows',
        meta: { title: '流程管理', noCache: true }
      },
      {
        path: 'designer',
        component: () => import('@/views/workflow-management/designer'),
        name: 'Designer',
        meta: { title: '流程设计', noCache: true }
      }
    ]
  },
  {
    path: '/bcmsManagement',
    component: Layout,
    redirect: 'noRedirect',
    name: 'BCMSManagement',
    meta: {
      title: 'BCMS集成环境',
      icon: '404'
    },
    children: [
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '服务注册', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '负载均衡', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '通讯调用', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '熔断降级', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '监控服务', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '聚合监控', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '路由网关', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '统一认证', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '服务总线', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '流式传输', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '消息队列', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '缓存管理', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '日志管理', noCache: true }
      },
      {
        path: 'index',
        component: () => import('@/views/bcms-management/index'),
        name: 'Page401',
        meta: { title: '作业调度', noCache: true }
      }
    ]
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: { title: 'Dashboard', icon: 'dashboard', affix: true }
      }
    ]
  },
  {
    path: '/documentation',
    component: Layout,
    children: [
      {
        path: 'index',
        component: () => import('@/views/documentation/index'),
        name: 'Documentation',
        meta: { title: 'Documentation', icon: 'documentation', affix: true }
      }
    ]
  },
  {
    path: '/guide',
    component: Layout,
    redirect: '/guide/index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/guide/index'),
        name: 'Guide',
        meta: { title: 'Guide', icon: 'guide', noCache: true }
      }
    ]
  },
  {
    path: '/profile',
    component: Layout,
    redirect: '/profile/index',
    hidden: true,
    children: [
      {
        path: 'index',
        component: () => import('@/views/profile/index'),
        name: 'Profile',
        meta: { title: 'Profile', icon: 'user', noCache: true }
      }
    ]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  {
    path: '/permission',
    component: Layout,
    redirect: '/permission/page',
    alwaysShow: true, // will always show the root menu
    name: 'Permission',
    meta: {
      title: 'Permission',
      icon: 'lock',
      roles: ['admin', 'editor'] // you can set roles in root nav
    },
    children: [
      {
        path: 'page',
        component: () => import('@/views/permission/page'),
        name: 'PagePermission',
        meta: {
          title: 'Page Permission',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'directive',
        component: () => import('@/views/permission/directive'),
        name: 'DirectivePermission',
        meta: {
          title: 'Directive Permission'
          // if do not set roles, means: this page does not require permission
        }
      },
      {
        path: 'role',
        component: () => import('@/views/permission/role'),
        name: 'RolePermission',
        meta: {
          title: 'Role Permission',
          roles: ['admin']
        }
      }
    ]
  },

  {
    path: '/icon',
    component: Layout,
    children: [
      {
        path: 'index',
        component: () => import('@/views/icons/index'),
        name: 'Icons',
        meta: { title: 'Icons', icon: 'icon', noCache: true }
      }
    ]
  },

  /** when your routing map is too long, you can split it into small modules **/
  componentsRouter,
  chartsRouter,
  nestedRouter,
  tableRouter,

  {
    path: '/example',
    component: Layout,
    redirect: '/example/list',
    name: 'Example',
    meta: {
      title: 'Example',
      icon: 'example'
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/example/create'),
        name: 'CreateArticle',
        meta: { title: 'Create Article', icon: 'edit' }
      },
      {
        path: 'edit/:id(\\d+)',
        component: () => import('@/views/example/edit'),
        name: 'EditArticle',
        meta: { title: 'Edit Article', noCache: true, activeMenu: '/example/list' },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/example/list'),
        name: 'ArticleList',
        meta: { title: 'Article List', icon: 'list' }
      }
    ]
  },

  {
    path: '/tab',
    component: Layout,
    children: [
      {
        path: 'index',
        component: () => import('@/views/tab/index'),
        name: 'Tab',
        meta: { title: 'Tab', icon: 'tab' }
      }
    ]
  },

  {
    path: '/error',
    component: Layout,
    redirect: 'noRedirect',
    name: 'ErrorPages',
    meta: {
      title: 'Error Pages',
      icon: '404'
    },
    children: [
      {
        path: '401',
        component: () => import('@/views/error-page/401'),
        name: 'Page401',
        meta: { title: '401', noCache: true }
      },
      {
        path: '404',
        component: () => import('@/views/error-page/404'),
        name: 'Page404',
        meta: { title: '404', noCache: true }
      }
    ]
  },

  {
    path: '/error-log',
    component: Layout,
    children: [
      {
        path: 'log',
        component: () => import('@/views/error-log/index'),
        name: 'ErrorLog',
        meta: { title: 'Error Log', icon: 'bug' }
      }
    ]
  },

  {
    path: '/excel',
    component: Layout,
    redirect: '/excel/export-excel',
    name: 'Excel',
    meta: {
      title: 'Excel',
      icon: 'excel'
    },
    children: [
      {
        path: 'export-excel',
        component: () => import('@/views/excel/export-excel'),
        name: 'ExportExcel',
        meta: { title: 'Export Excel' }
      },
      {
        path: 'export-selected-excel',
        component: () => import('@/views/excel/select-excel'),
        name: 'SelectExcel',
        meta: { title: 'Export Selected' }
      },
      {
        path: 'export-merge-header',
        component: () => import('@/views/excel/merge-header'),
        name: 'MergeHeader',
        meta: { title: 'Merge Header' }
      },
      {
        path: 'upload-excel',
        component: () => import('@/views/excel/upload-excel'),
        name: 'UploadExcel',
        meta: { title: 'Upload Excel' }
      }
    ]
  },

  {
    path: '/zip',
    component: Layout,
    redirect: '/zip/download',
    alwaysShow: true,
    name: 'Zip',
    meta: { title: 'Zip', icon: 'zip' },
    children: [
      {
        path: 'download',
        component: () => import('@/views/zip/index'),
        name: 'ExportZip',
        meta: { title: 'Export Zip' }
      }
    ]
  },

  {
    path: '/pdf',
    component: Layout,
    redirect: '/pdf/index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/pdf/index'),
        name: 'PDF',
        meta: { title: 'PDF', icon: 'pdf' }
      }
    ]
  },
  {
    path: '/pdf/download',
    component: () => import('@/views/pdf/download'),
    hidden: true
  },

  {
    path: '/theme',
    component: Layout,
    children: [
      {
        path: 'index',
        component: () => import('@/views/theme/index'),
        name: 'Theme',
        meta: { title: 'Theme', icon: 'theme' }
      }
    ]
  },

  {
    path: '/clipboard',
    component: Layout,
    children: [
      {
        path: 'index',
        component: () => import('@/views/clipboard/index'),
        name: 'ClipboardDemo',
        meta: { title: 'Clipboard', icon: 'clipboard' }
      }
    ]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://github.com/PanJiaChen/vue-element-admin',
        meta: { title: 'External Link', icon: 'link' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
